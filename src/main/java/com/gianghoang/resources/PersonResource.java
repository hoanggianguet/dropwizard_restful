package com.gianghoang.resources;

import com.gianghoang.DTO.PersonDTO;
import com.gianghoang.core.Person;
import com.gianghoang.db.PersonDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rock Lee on 20/08/2016.
 */
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    final int PAGE_SIZE = 100;
    private PersonDAO personDAO;
    public PersonResource(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GET
    @Path("/json/{quantity}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<PersonDTO> getListPerson(@PathParam("quantity") int quantity) {
        List<PersonDTO> list = new ArrayList<>();
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAge(150);
        personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(new Date(3)));
        personDTO.setName("James Bone");
        personDTO.setSex("male");

        for (int i= 0; i< quantity ; i++){
            list.add(personDTO);
        }
        System.out.println(list);
        return list;
    }

    @GET
    @Path("/db-json/all")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<PersonDTO> getAll() {
//        PageRequest request = new PageRequest(1, PAGE_SIZE);
//        Page<Person> personPage = personDAO.findAll(request);
        List<PersonDTO> list = new ArrayList<>();
        createPerson();
        List<Person> personList =  personDAO.findAll();
        for (Person person: personList){
            PersonDTO personDTO = new PersonDTO();
            personDTO.setName(person.getName());
            personDTO.setSex(person.getSex());
            personDTO.setAge(person.getAge());
            personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            list.add(personDTO);

        }
        return list;

    }

    @GET
    @Path("/db-json/{pageNumber}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Person> getUserWithPage(@PathParam("pageNumber") int pageNumber) {
        return personDAO.findByAgeGreaterThan(pageNumber-1, 0, PAGE_SIZE);
//        PageRequest request = new PageRequest(pageNumber-1, PAGE_SIZE);
//           Page<Person> personPage = personDAO.findAll(request);
//        return personPage;
//        List<Person> personList = personPage.getContent();
//
//        List<PersonDTO> personDTOs = new ArrayList<>();
//        PersonDTO personDTO = new PersonDTO();
//
//        for(int i = 0; i < personList.size(); i++){
//            personDTO.setName(personList.get(i).getName());
//            personDTO.setAge(personList.get(i).getAge());
//            personDTO.setSex(personList.get(i).getSex());
//            personDTO.setBirthday(new SimpleDateFormat("dd-mm-yyyy").format(personList.get(i).getBirthday()));
//            personDTOs.add(personDTO);
//        }
//
//        PageDTO pageDTO = new PageDTO();
//        pageDTO.setPersonList(personDTOs);
//        pageDTO.setTotalPage(personPage.getTotalPages());
//        pageDTO.setNumberOfElements(personPage.getNumberOfElements());
//        pageDTO.setPageCurrent(personPage.getNumber() + 1);
//        pageDTO.setSize(personPage.getSize());
//        pageDTO.setTotalElements(personPage.getTotalElements());
//
//        return pageDTO;
    }

    private void createPerson(){
        for (int i = 1 ; i<= 400; i++){
            Person person = new Person();
            person.setName("Jame"+i);
            person.setAge(30);
            person.setBirthday(new Date());
            person.setSex("male");
            personDAO.create(person);
        }
    }
}
