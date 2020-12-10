package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorsList {
    private ArrayList<Doctor> doctorgroup = new ArrayList<>();
    Statement statement = null;

    public void doctorFill(){
        try {
            statement = AmbulanceDB.connectDB().createStatement();
            ResultSet result = statement.executeQuery("SELECT * From Doctor");

            for(; result.next();){
                Doctor doctor = new Doctor();

                int doctorid = result.getInt(1);
                String sname = result.getString(2);
                String slname = result.getString(3);
                Double mog = result.getDouble(4);
                int groupId = result.getInt(5);

                doctor.setDoctorid(doctorid);
                doctor.setSname(sname);
                doctor.setSlname(slname);
                doctor.setMog(mog);
                doctor.setGroupId(groupId);

                Doctorgroup.add(doctor);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteDoctor(int doctorId){
        try {
            statement = AmbulanceDB.connectDB().createStatement();
            String deleteDoctorQuery = "Delete from Doctor where sttudentId = " + doctorId;
            statement.executeUpdate(deleteDoctorQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doctorPrint(){
        System.out.println(doctorgroup);
    }

    public String textDoctor(){
        String row = "";
        for (int i = 0; i < doctorgroup.size(); i++){
            row += doctorgroup.get(i).getDoctorid() + " ";
            row += doctorgroup.get(i).getSname() + " ";
            row += doctorgroup.get(i).getSlname() + " ";
            row += doctorgroup.get(i).getMog() + " ";
            row += doctorgroup.get(i).getGroupId() + " \n";
        }
        return row;
    }

    public void insertDoctor(String sname, String slname, Double mog, int groupId){
        try{
            statement = AmbulanceDB.connectDB().createStatement();
            String insertQuery = "INSERT into Doctor values (" + null + ", '" + sname +
                    "','" + slname + "','" + mog + "','" + groupId + ");";
            statement.executeUpdate(insertQuery);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
