package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;


public class App 
{
    public static void main(String[] args) {
		System.out.println("my program statred");
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		
		StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
		
		Student student = new Student();
		
//		Insertion
//		student.setId(5);
//		student.setName("Harish");
//		student.setCity("Dvg");
//		
//		int res = studentDao.insert(student);
		
//		UPDATION
//		student.setId(4);
//		student.setName("RajKumar");
//		student.setCity("Gajanuru");
//		
//		int res = studentDao.change(student);
		
//		DELETION
//		student.setId(5);
//		
//		int res = studentDao.delete(student);
//		System.out.println(res);
		
//		SELECTING USING SINGLE OBJECT
		
//		Student student2 = studentDao.getStudent(1);
//		System.out.println(student2);
		
//		SELECTING MULTIPLE ROWS
		
		
		List<Student> students = studentDao.getAllStudents();
		for(Student s:students) {
			System.out.println(s);
		}
		
    }
}
 