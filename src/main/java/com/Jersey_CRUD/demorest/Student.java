package com.Jersey_CRUD.demorest;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Student {

	
	private String name;
	private Date dateofbirth;
	private Date dateofJoin;
	private int studentno;
	
	public Student() {
		this.name = "Sample";
		this.dateofbirth = new Date();
		this.dateofJoin = new Date();	
		}
	
	public Student(String name, Date dateofbirth, Date dateofJoin, int studentno) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.dateofJoin = dateofJoin;
		this.studentno = studentno;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", dateofbirth=" + dateofbirth + ", dateofJoin=" + dateofJoin + ", studentno="
				+ studentno + "]";
	}

	public Student(String name, Date dateofbirth, Date dateofJoin) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.dateofJoin = dateofJoin;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Date getDateofJoin() {
		return dateofJoin;
	}
	public void setDateofJoin(Date dateofJoin) {
		this.dateofJoin = dateofJoin;
	}
	public int getStudentno() {
		return studentno;
	}
	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}

}
