package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.modal.Student;

@Repository
@Qualifier("StudentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(Student s) {
		int row = jdbcTemplate.update("INSERT INTO student VALUES(?, ?, ?)", s.getId(), s.getName(), s.getMarks());
		if (row > 0)
			return true;
		return false;
	}

	public List<Student> getAll() {
		List<Student> students = jdbcTemplate.query("SELECT * FROM student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getFloat("marks"));
				return student;
			}});
		return students;
	}

}
