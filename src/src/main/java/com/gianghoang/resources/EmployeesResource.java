package com.gianghoang.resources;

import com.gianghoang.core.Employee;
import com.gianghoang.db.EmployeeDAO;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/employees")

public class EmployeesResource {

    /**
     * The DAO object to manipulate employees.
     */
    private EmployeeDAO employeeDAO;

    /**
     * Constructor.
     *
     * @param employeeDAO DAO object to manipulate employees.
     */
    public EmployeesResource(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    /**
     * Looks for employees whose first or last name contains the passed
     * parameter as a substring. If name argument was not passed, returns all
     * employees stored in the database.
     *
     * @param name query parameter
     * @return list of employees whose first or last name contains the passed
     * parameter as a substring or list of all employees stored in the database.
     */
    @GET
    @Path("/testsss")
    @UnitOfWork
    public List<Employee> findByName(
            @QueryParam("name") Optional<String> name
    ) {
        if (name.isPresent()) {
            return employeeDAO.findByName(name.get());
        } else {
            return employeeDAO.findAll();
        }
    }


    /**
     * Method looks for an employee by her id.
     *
     * @param id the id of an employee we are looking for.
     * @return Optional containing the found employee or an empty Optional
     * otherwise.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Employee findById(@PathParam("id") long id) {
        Employee employee= employeeDAO.findById(id);
        return employee;
    }


    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Employee insertEmployee(
                                   ){
        Employee employee = new Employee("Giang","Hoang","HaNoi","24234","asdfasdf");
         employeeDAO.create(employee);
        return null;
//        return firstName + lastName + position;
    }
}

//    @FormParam("firstName") String firstName,
//    @FormParam("lastName") String lastName,
//    @FormParam("position") String position,
//    @FormParam("phone") String phone,
//    @FormParam("e_mail") String email