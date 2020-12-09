package com.company;

public class Ambulance {
}
package com.company;

public class Student {
    private int studentid;
    private String sname;
    private String slname;
    private double mog;
    private int groupId;


    public Student() {
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSlname() {
        return slname;
    }

    public void setSlname(String slname) {
        this.slname = slname;
    }

    public double getMog() {
        return mog;
    }

    public void setMog(double mog) {
        this.mog = mog;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Student(int studentid, String sname, String slname, double mog, int groupId) {
        this.studentid = studentid;
        this.sname = sname;
        this.slname = slname;
        this.mog = mog;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", sname='" + sname + '\'' +
                ", slname='" + slname + '\'' +
                ", mog=" + mog +
                ", groupId=" + groupId +
                '}';
    }
}
