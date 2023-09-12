package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;

@Component("studentDao")
public class StudentImple implements StudentDao {

	
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
//		Insert
		String query = "insert into student(id,name,city) values(?,?,?)";
		int res = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return res;
	}

	public int change(Student student) {
//update 
		String query = "update student set name=?,city=? where id =?";
		int res = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return res;
	}

	public int delete(Student student) {
//			Delete 
		String query = "delete from student where id=?";
		int res = jdbcTemplate.update(query, student.getId());

		return res;
	}

//	Selecting Single Student
	public Student getStudent(int studentId) {
		RowMapper<Student> rowMapper = new RowMapperImpl();
		String query = "select * from student where id=?";
		Student student = jdbcTemplate.queryForObject(query, rowMapper, studentId);

		return student;
	}
	
//	Get All Student 
	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> students =jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

}
