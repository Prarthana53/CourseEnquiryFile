/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.courseenquiry.dao;

import com.prarthana.courseenquiry.ent.Course;
import java.util.List;

/**
 *
 * @author Pavilion G4
 */
public interface CourseDAO {
    boolean insert(Course c);
    boolean searchById(int id);
    List<Course> getAll();
    
}
