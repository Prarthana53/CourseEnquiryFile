/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.courseenquiry.dao.impl;

import com.prarthana.courseenquiry.dao.EnquiryDAO;
import com.prarthana.courseenquiry.ent.Enquiry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pavilion G4
 */
public class EnquiryDAOImpl implements EnquiryDAO{
    private int count=0;
   private List<Enquiry> enqList=new ArrayList<>();

    @Override
    public boolean insert(Enquiry e) {
        return enqList.add(e);
       
    }

    @Override
    public boolean searchByEmail(String email) {
        for(Enquiry e:enqList){
        if(e.getEmail().contentEquals(email)){
        return true;
        }
        }
        return false;
    }

    @Override
    public List<Enquiry> getAll() {
        return enqList;
    }

 /* @Override
    public boolean empty(String email) {
        for(Enquiry e:enqList){
        if(!e.getEmail().trim().isEmpty()){
        return false;
        }
        
        }
        return true;
    }*/
    
}
