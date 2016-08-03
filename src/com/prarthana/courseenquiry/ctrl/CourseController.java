/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.courseenquiry.ctrl;

import com.prarthana.courseenquiry.dao.CourseDAO;
import com.prarthana.courseenquiry.dao.EnquiryDAO;
import com.prarthana.courseenquiry.ent.Course;
import com.prarthana.courseenquiry.ent.Enquiry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Pavilion G4
 */
public class CourseController {
    CourseDAO cd;
    EnquiryDAO enqDAO;

    public CourseController() {
    }

    public CourseController(CourseDAO cd, EnquiryDAO enqDAO) {
        this.cd = cd;
        this.enqDAO = enqDAO;
    }
    
    
    public void process() throws IOException
    {
        course();
        System.out.println("===============================");
        enquiry();
    
    }
    private void course() throws FileNotFoundException, IOException
    {
       System.out.println("Course Details.......");
        try ( 
            BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\Pavilion G4\\Desktop\\output\\course.csv")))
                {
            String line="";
            while((line=bufferedReader.readLine())!=null)
            {
                Course c = new Course();
                String[] tokens=line.split(",");
                c.setId(Integer.parseInt(tokens[0]));
                c.setName(tokens[1]);
                c.setFee(Double.parseDouble(tokens[2]));
                
                cd.insert(c);
                if (!cd.insert(c)) {
                    System.out.println("Sorry!! can't get the course.");
                }
                
                
            }
            
            bufferedReader.close();
        }
    }
     private void enquiry() throws FileNotFoundException, IOException,ArrayIndexOutOfBoundsException
    {
         System.out.println("Student Enquiry Details......");
         
        try ( BufferedReader bufferedReader1 = new BufferedReader(new FileReader("C:\\Users\\Pavilion G4\\Desktop\\output\\enquiry.csv"))) {
            BufferedWriter errorWriter =new BufferedWriter(new FileWriter("C:\\Users\\Pavilion G4\\Desktop\\output\\error.csv"));
         BufferedWriter interruptWriter =new BufferedWriter(new FileWriter("C:\\Users\\Pavilion G4\\Desktop\\output\\interrupt.csv"));
            String line1="";
            while((line1=bufferedReader1.readLine())!=null)
            {
                String[] tokens1=line1.split(",");
                Enquiry e = new Enquiry();
               try{
                   if((enqDAO.searchByEmail(tokens1[4]))||(!cd.searchById(Integer.parseInt(tokens1[1]))))
                {
                    writeToErrorFile(tokens1,errorWriter);
                } 
                   
                   
                  /* else if(enqDAO.empty(tokens1[4])){
                   
                    writeToErrorFile(tokens1,errorWriter);
                   }*/
                   
                else{
                    
                    e.setStuId(Integer.parseInt(tokens1[0]));
                    e.setCode(Integer.parseInt(tokens1[1]));
                    e.setfName(tokens1[2]);
                    e.setlName(tokens1[3]);
                    e.setEmail(tokens1[4]);
                    
                    enqDAO.insert(e);
                    
                  
                  
                    writeToInterruptFile(e,interruptWriter);  
                    
                    if (!enqDAO.insert(e)) {
                        System.out.println("Sorry! Cannot Insert into Enquiry !!");
                    }
                }
               } catch (ArrayIndexOutOfBoundsException ae){
                           ae.getMessage();
                           } 
                
            }
              errorWriter.close();
              interruptWriter.close();
              bufferedReader1.close();
            
        }
         
        
        
    }
      private void writeToErrorFile(String[] array,BufferedWriter errorWriter) throws IOException
    {
        
                
                 
            
                try {
                  /*  if(enqDAO.empty()){
                    array[4]="";
                    }*/
                    errorWriter.write(array[0]+","+array[1]+","+array[2]+"," +array[3]+","+array[4]);
                    errorWriter.newLine();
                    
                } catch (IOException i) {
                    System.out.println(i.getMessage());
                }
            
       
          
        
                    
    }
       private void writeToInterruptFile(Enquiry e,BufferedWriter interruptWriter) throws IOException
    {        
                try {
                    
                    interruptWriter.write(e.getStuId()+","+e.getCode()+","+e.getfName()+","+e.getlName()+","+e.getEmail());
                    interruptWriter.newLine();
                    
                } catch (IOException io) {
                    System.out.println(io.getMessage());
                }
           
           
         
        
                    
                
    }
    
    
    
    
    
}
