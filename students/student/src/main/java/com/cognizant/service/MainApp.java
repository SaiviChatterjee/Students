package com.cognizant.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.dao.StudentDao;
import com.cognizant.modal.Student;

public class MainApp {
	
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(resources.ApplicationConfig.class);
    	StudentDao studentDao = (StudentDao)context.getBean("studentDao");
    	Student s1 = new Student(1, "Saivi", 100);
    	Student s2 = new Student(2, "Sejal", 90);
    	Student s3 = new Student(3, "Puja", 95);
    	studentDao.insert(s1);
    	studentDao.insert(s2);
    	studentDao.insert(s3);
        List<Student> students = studentDao.getAll();
        for(Student s: students) {
        	System.out.println(s);
        }
    }
}
