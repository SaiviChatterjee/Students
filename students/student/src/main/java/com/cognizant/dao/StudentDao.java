package com.cognizant.dao;

import java.util.List;

import com.cognizant.modal.Student;

public interface StudentDao {
	public boolean insert(Student student);
	public List<Student> getAll();
}
