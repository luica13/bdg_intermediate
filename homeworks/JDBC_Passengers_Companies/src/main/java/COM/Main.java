package COM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Main {


    private static final String folderURL =  "D:\\for Projects\\Java\\resouses\\homework(JDBC)";
    public static void main(String[] args) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/airport_managment";

        //  Database credentials
        String name = "root";
        String pass = "root";
        Connection conn = null;
        Statement stmt = null;
        ArrayList<String[]>  companiesArrayList = arrayFromFile("companies.txt");
        ArrayList<String[]>  addressPassengerArrayList = arrayFromFile("passengers.txt");
        try {
            conn = DriverManager.getConnection(url,name,pass);
            System.out.println("Connected database successfully...");
            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            if (companiesArrayList!=null) {
                System.out.println("filling companies");
                fillCompanies(companiesArrayList, conn);

            }
            if (addressPassengerArrayList!=null) {
                System.out.println("filling address and passengers");
                fillAddressPassenger(addressPassengerArrayList, conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        };


    }

    public static ArrayList<String[]>  arrayFromFile(String fileName) {
        // = "";
        FileReader input = null;
        ArrayList<String[]> retArrayList = null;
        try {
            input = new FileReader(folderURL+"\\"+fileName);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = null;

            if(bufRead.readLine()==null)
                return retArrayList;

            retArrayList = new ArrayList<>();
            while ( (myLine = bufRead.readLine()) != null)
            {
                String[] array1 = myLine.split(",");
                retArrayList.add(array1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't read from file");
            e.printStackTrace();
        }

        return retArrayList;
    }

    public static void  fillCompanies(ArrayList<String[]> companiesList, Connection conn) throws SQLException {
        String sql="";
        Statement stmt = conn.createStatement();
        for (String[] sArray:
             companiesList) {
            //language = sql
            sql = "INSERT INTO company(name, foundingDate) "
                    + "VALUES ('"+sArray[0]+"', STR_TO_DATE('"+sArray[1]+"', '%m/%d/%Y'))";
            stmt.executeUpdate(sql);
        }



    }

    public static void  fillAddressPassenger(ArrayList<String[]> addressPassengerList, Connection conn) throws SQLException {
        String sql="";
        PreparedStatement pstmtA = conn.prepareStatement("INSERT INTO address(country, city) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
        for (String[] sArray:
                addressPassengerList) {

            pstmtA.setString(1,sArray[2]);
            pstmtA.setString(2,sArray[3]);

            if (pstmtA.executeUpdate() > 0)
            {
                ResultSet genKeys = pstmtA.getGeneratedKeys();
                if (genKeys.next()) {
                    long addressId = genKeys.getLong(1);
                    addPassenger(conn,addressId,sArray[0],sArray[1]);
                }
                else {
                    throw new SQLException("Creating address failed, no ID obtained.");
                }

            }

        }



    }

    public static void  addPassenger(Connection conn, long addressId,String name, String passengerPhone) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO passenger(name, passengerPhone, addressID) "
                    + "VALUES (?,?,?)";
        PreparedStatement pstmtP = conn.prepareStatement(sql);
        pstmtP.setString(1,name);
        pstmtP.setString(2,passengerPhone);
        pstmtP.setLong(3, addressId);
        if (pstmtP.executeUpdate() == 0)
        {
            throw new SQLException("Creating passenger failed");
        }
    }


}
