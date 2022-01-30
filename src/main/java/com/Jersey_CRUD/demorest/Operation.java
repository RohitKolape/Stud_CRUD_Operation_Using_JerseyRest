package com.Jersey_CRUD.demorest;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Operation {

	private static String insert_student = "insert into student(student_name,student_dob,student_doj)values(?,?,?)";
	private static String update_student = "update student set student_name = ?,student_dob= ?, student_doj =? where student_no = ?";
	private static String select_all_students = "select * from student";
	private static String select_student_by_id = "select student_no,student_name,student_dob,student_doj from student where student_no = ?";
	private static String delete_student = "delete from student where student_no = ?;";

	private static connect c = new connect();

	
	
	private static java.sql.Date convert_utility_to_sql(java.util.Date date) {
		java.sql.Date mysqlDate = new java.sql.Date(date.getTime());
		return mysqlDate;
	}

	
	
	public void insertStudent(Student student) {

		try {
			java.util.Date birthdt;
			java.util.Date year_of_join;
			
			java.sql.Date sql_birth_dt;
			java.sql.Date sql_year_of_join;
			
			birthdt = student.getDateofbirth();
			sql_birth_dt = convert_utility_to_sql(birthdt);

			year_of_join = student.getDateofJoin();
			sql_year_of_join = convert_utility_to_sql(year_of_join);
					
			Connection con = c.sqlret();
			PreparedStatement pst = con.prepareStatement(insert_student);
			pst.setString(1, student.getName());
			pst.setDate(2, sql_birth_dt);
			pst.setDate(3, sql_year_of_join);

			int x = pst.executeUpdate();
			if (x != 0) {
				System.out.print("Inserted Sucess");
			} else {
				System.out.print("insert Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public List<Student> selectUserById(int student_id) {
		Student stud = null;
		List<Student> student = new ArrayList<Student>();
		try {
			Connection con = c.sqlret();
			PreparedStatement pst = con.prepareStatement(select_student_by_id);
			pst.setInt(1, student_id);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int number = rs.getInt("student_no");
				String name = rs.getString("student_name");
				java.util.Date dob = rs.getDate("student_dob");
				java.util.Date doj = rs.getDate("student_doj");
				stud = new Student(name, dob, doj, number);
				student.add(stud);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Selecting the student by id");
		return student;
	}

	
	
	public Student selectUserByIdforEdit(int student_id) {
		Student stud = null;

		try {
			Connection con = c.sqlret();
			PreparedStatement pst = con.prepareStatement(select_student_by_id);
			pst.setInt(1, student_id);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int number = rs.getInt("student_no");
				String name = rs.getString("student_name");
				java.util.Date dob = rs.getDate("student_dob");
				java.util.Date doj = rs.getDate("student_doj");
				stud = new Student(name, dob, doj, number);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Selecting the student by id");
		return stud;
	}

	
	
	public List<Student> Allstudent() {
		List<Student> students = new ArrayList<Student>();

		try {
			Connection con = c.sqlret();
			PreparedStatement pst = con.prepareStatement(select_all_students);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				int student_no = rs.getInt(1);
				String student_name = rs.getString(2);
				Date student_dob = rs.getDate(3);
				Date student_doj = rs.getDate(4);
//			System.out.println("inside All student method");
				System.out.println(student_no + student_name + student_dob + student_doj);
				Student student = new Student(student_name, student_dob, student_doj, student_no);
				students.add(student);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return students;
	}

	
	
	public boolean DeleteStudent(int student_id) {
		boolean rowdeleted = false;

		try {
			Connection con = c.sqlret();
			PreparedStatement pst = con.prepareStatement(delete_student);
			pst.setInt(1, student_id);
			rowdeleted = pst.executeUpdate() > 0;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return rowdeleted;
	}

	
	
	public boolean UpdateStudent(Student student) {
		boolean rowupdated = false;
		try {
			Connection con = c.sqlret();
			PreparedStatement pst = con.prepareStatement(update_student);

			
			java.util.Date birthdt;
			java.util.Date year_of_join;
			
			java.sql.Date sql_birth_dt;
			java.sql.Date sql_year_of_join;
			System.out.println("Inside update operation");
			birthdt = student.getDateofbirth();
			sql_birth_dt = convert_utility_to_sql(birthdt);

			year_of_join = student.getDateofJoin();
			sql_year_of_join = convert_utility_to_sql(year_of_join);
			
			pst.setString(1, student.getName());
			pst.setDate(2, sql_birth_dt);
			pst.setDate(3, sql_year_of_join);
			pst.setInt(4, student.getStudentno());

			rowupdated = pst.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowupdated;
	}

}
