/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.courseenquiry.ent;

/**
 *
 * @author Pavilion G4
 */
public class Enquiry {
    private int stuId,code;
    private String fName;
     private String lName; 
       private String email;

    public Enquiry() {
    }

    public Enquiry(int stuId, int code, String fName, String lName, String email) {
        this.stuId = stuId;
        this.code = code;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
       
       
       
}
