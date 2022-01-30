package com.Jersey_CRUD.demorest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.text.ParseException;
import java.util.*;

@Path("students")
public class StudentResource
{
	Operation op = new Operation();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student>getStudents(){
//		Operation op = new Operation();
		
		List<Student> students = op.Allstudent();	
		
		
		return students;
	}
	
	@GET
	@Path("studentbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("id")int id) {
		List<Student> students = op.Allstudent();
		for(Student s:students) {
			if(s.getStudentno() == id) {
				return s;
			}
		}
		return new Student();
	}

	@POST
	@Path("insertstudent")
	public Student insertStudent(Student s) {
		
		System.out.println(s);
		op.insertStudent(s);
		
		return s;
	}
	
	@PUT
	@Path("updatestudent")
	public Student updateStudent(Student s) throws ParseException {
		boolean flag = true;
		System.out.println(s);
		flag = op.UpdateStudent(s);
		if(flag) {
			System.out.println("Update Successful");
		}
		else {
			System.out.println("Update not Successful");
		}
		return s;
	}

	
	@DELETE
	@Path("deletestudent/{id}")
	public void DeleteStudent(@PathParam("id")int id){

		
		boolean flag = op.DeleteStudent(id);
		if(flag) {
			System.out.println("Delete Successful");
		}
		else {
			System.out.println("Delete not Successful");
		}
		
	}

	
	
}
