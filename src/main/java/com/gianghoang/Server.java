package com.gianghoang;

import com.gianghoang.iController.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Created by Administrator on 8/19/2016.
 */
@Configuration("com.gianghoang")
@ComponentScan("com.gianghoang")
public class Server {
    private static final int PORT = 1098;
    @Bean
    public RmiServiceExporter rmiServiceExporterHello(IHello hello) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(hello);
        rmiServiceExporter.setServiceName("Hello");
        rmiServiceExporter.setServiceInterface(IHello.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter rmiServiceExporterCPU(ICpu cpu) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(cpu);
        rmiServiceExporter.setServiceName("CPU");
        rmiServiceExporter.setServiceInterface(ICpu.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter rmiServiceExporterNetio(INetio netio) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(netio);
        rmiServiceExporter.setServiceName("Netio");
        rmiServiceExporter.setServiceInterface(INetio.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter rmiServiceExporterPerson(IPerson person) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(person);
        rmiServiceExporter.setServiceName("Person");
        rmiServiceExporter.setServiceInterface(IPerson.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter rmiServiceExporterRsa(IRsa rsa) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(rsa);
        rmiServiceExporter.setServiceName("Rsa");
        rmiServiceExporter.setServiceInterface(IRsa.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter rmiServiceExporterString(IString string) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(string);
        rmiServiceExporter.setServiceName("String");
        rmiServiceExporter.setServiceInterface(IString.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter rmiServiceExporterStudent(IStudent student) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(student);
        rmiServiceExporter.setServiceName("Student");
        rmiServiceExporter.setServiceInterface(IStudent.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter rmiServiceExporterTime(ITime time) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(time);
        rmiServiceExporter.setServiceName("Time");
        rmiServiceExporter.setServiceInterface(ITime.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

}
