/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.courseenquiry.dao;

import com.prarthana.courseenquiry.ent.Enquiry;
import java.util.List;

/**
 *
 * @author Pavilion G4
 */
public interface EnquiryDAO {
     boolean insert(Enquiry e);
     boolean searchByEmail(String email);
   // boolean empty(String email);
     
     List<Enquiry> getAll();
}
