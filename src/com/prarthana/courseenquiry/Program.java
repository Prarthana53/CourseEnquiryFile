/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.courseenquiry;

import com.prarthana.courseenquiry.ctrl.CourseController;
import com.prarthana.courseenquiry.dao.CourseDAO;
import com.prarthana.courseenquiry.dao.EnquiryDAO;
import com.prarthana.courseenquiry.dao.impl.CourseDAOImpl;
import com.prarthana.courseenquiry.dao.impl.EnquiryDAOImpl;
import java.io.FileNotFoundException;

import java.io.IOException;

/**
 *
 * @author Pavilion G4
 */
public class Program {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        CourseDAO cd = new CourseDAOImpl();

        EnquiryDAO enqDAO = new EnquiryDAOImpl();
        CourseController cc=new CourseController(cd,enqDAO);
        cc.process();

       
    }
}
