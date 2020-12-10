package com.company;

public class Doctors {
    private int doctorid;
    private String sname;
    private String slname;
    private double mog;
    private int groupId;


    public Doctor() {
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
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

    public Doctor (int doctorid, String sname, String slname, double mog, int groupId) {
        this.doctorid = doctorid;
        this.sname = sname;
        this.slname = slname;
        this.mog = mog;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorid=" + doctorid +
                ", sname='" + sname + '\'' +
                ", slname='" + slname + '\'' +
                ", mog=" + mog +
                ", groupId=" + groupId +
                '}';
    }
}
