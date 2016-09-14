package com.gianghoang.db;

import com.gianghoang.core.Person;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rock Lee on 20/08/2016.
 */
@Component
@Transactional
public class PersonDAO extends AbstractDAO<Person> {

    @PersistenceContext
    EntityManager entityManager;

    public PersonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public List<Person> findAll() {
        return list(namedQuery("com.gianghoang.Person.findAll"));
    }

    public List<Person> findByAgeGreaterThan(int age, int pageIndex, int pageSize) {

        String sql = "select p from Person p where p.age > :age order by age asc ";

        Session session = currentSession();
        org.hibernate.Query query = session.createQuery(sql);
        query.setParameter("age", age);
        query.setFirstResult(pageIndex * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

    public Person create(Person person) {
        return persist(person);
    }

    public Person findById(long id) {
        return get(id);
    }

}
