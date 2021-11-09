package com.example.campusbox;

public class Display {

    String msource, mdest, mdate, mtime, mmaxpass, mname, memail,mphone;

    public Display(){}

    public Display(String msource, String mdest, String mdate, String mtime, String mmaxpass, String mname, String memail, String mphone) {
        this.msource = msource;
        this.mdest = mdest;
        this.mdate = mdate;
        this.mtime = mtime;
        this.mmaxpass = mmaxpass;
        this.mname = mname;
        this.memail = memail;
        this.mphone = mphone;
    }

    public String getMsource() {
        return msource;
    }

    public void setMsource(String msource) {
        this.msource = msource;
    }

    public String getMdest() {
        return mdest;
    }

    public void setMdest(String mdest) {
        this.mdest = mdest;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getMmaxpass() {
        return mmaxpass;
    }

    public void setMmaxpass(String mmaxpass) {
        this.mmaxpass = mmaxpass;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }
}
