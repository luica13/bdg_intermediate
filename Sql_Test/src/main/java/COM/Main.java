package COM;

import java.sql.*;

public class Main
{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bdg_1";
        String name = "root";
        String pass = "root";
        //language=sql
        String sqlSelect = "Select * From table_name_1 left join table_name on table_name_1.ID=table_name.ID";
        try (Connection connection = DriverManager.getConnection(url,name,pass);
             PreparedStatement ps = connection.prepareStatement(sqlSelect);
             ResultSet rs = ps.executeQuery();
             //ResultSet resultSet = ps.getResultSet();
        ) {
            while (rs.next())
            {
                System.out.println(rs.getString(1) + "_" + rs.getString(2)+"_"
                        + rs.getString(3)+"_" + rs.getString(4)+ rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
