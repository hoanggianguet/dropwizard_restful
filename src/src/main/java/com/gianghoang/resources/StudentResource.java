package com.gianghoang.resources;

import com.gianghoang.core.Student;
import com.gianghoang.db.StudentDAO;
import io.dropwizard.hibernate.UnitOfWork;
import org.apache.commons.lang3.RandomStringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rock Lee on 23/08/2016.
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
    private StudentDAO studentDAO;

    public StudentResource(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GET
    @Path("/{hello}")
    public String createRamdomWords(@PathParam("hello") String hello) {

        return hello;
    }

    @GET
    @Path("/db/{quantity}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Student> createRamdomWords(@PathParam("quantity") int quantity) {
        for (int i = 0; i < quantity; i++) {
            createStudent();
        }
        List<Student> students = new ArrayList<>();
        List<Student> studentList =  studentDAO.findAll();
        for (Student student: studentList){
            students.add(student);
        }
        return students;
    }

//    @GET
//    @Path("/create")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @UnitOfWork
    public void createStudent() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        RandomStringUtils rd = new RandomStringUtils();
        Student student = new Student();
        student.setName(rd.random(1024, chars));
        studentDAO.create(student);
    }
}
