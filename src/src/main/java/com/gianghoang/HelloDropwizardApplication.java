package com.gianghoang;

import com.gianghoang.core.Employee;
import com.gianghoang.core.Person;
import com.gianghoang.core.Student;
import com.gianghoang.db.EmployeeDAO;
import com.gianghoang.db.PersonDAO;
import com.gianghoang.db.StudentDAO;
import com.gianghoang.resources.*;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration("com.gianghoang")
@ComponentScan("com.gianghoang")
public class HelloDropwizardApplication extends Application<HelloDropwizardConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloDropwizardApplication.class);

    public static void main(final String[] args) throws Exception {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloDropwizardApplication.class);
        new HelloDropwizardApplication().run("server", "config.yml");
    }

    private final HibernateBundle<HelloDropwizardConfiguration> hibernateBundle
            = new HibernateBundle<HelloDropwizardConfiguration>(
            Employee.class,
            Student.class,
            Person.class
    ) {

        @Override
        public DataSourceFactory getDataSourceFactory(
                HelloDropwizardConfiguration configuration
        ) {
            return configuration.getDataSourceFactory();
        }

    };


    @Override
    public String getName() {
        return "HelloDropwizard";
    }

    @Override
    public void initialize(final Bootstrap<HelloDropwizardConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final HelloDropwizardConfiguration configuration,
                    final Environment environment) {

        // TODO: implement application
        final EmployeeDAO employeeDAO
                = new EmployeeDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new EmployeesResource(employeeDAO));
        final StudentDAO studentDAO
                = new StudentDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new StudentResource(studentDAO));
        final PersonDAO personDAO
                = new PersonDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new PersonResource(personDAO));

        final HelloWorldResource resource = new HelloWorldResource();
        final CpuResource cpuResource = new CpuResource();
        final NetioResource netioResource = new NetioResource();
        final HelloResource helloResource = new HelloResource();
        final StringResource stringResource = new StringResource();
        final RsaResource rsaResource = new RsaResource();
        final TimeResource timeResource = new TimeResource();
        environment.jersey().register(cpuResource);
        environment.jersey().register(resource);
        environment.jersey().register(netioResource);
        environment.jersey().register(helloResource);
        environment.jersey().register(stringResource);
        environment.jersey().register(rsaResource);
        environment.jersey().register(timeResource);
        environment.jersey().register(timeResource);
    }
}
