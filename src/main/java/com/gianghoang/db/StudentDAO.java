package com.gianghoang.db;

import com.gianghoang.core.Student;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Rock Lee on 24/08/2016.
 */
public class StudentDAO extends AbstractDAO<Student> {
    public StudentDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Student> findAll() {
        return list(namedQuery("com.gianghoang.Student.findAll"));
    }

    public Student create(Student student){
        return persist(student);
    }
    public Student findById(long id) {
        return get(id);
    }
}
