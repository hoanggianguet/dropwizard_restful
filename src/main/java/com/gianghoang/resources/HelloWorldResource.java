package com.gianghoang.resources;


import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
//    private final String template;
//    private final String defaultName;
//    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
//        this.template = template;
//        this.defaultName = defaultName;
//        this.counter = new AtomicLong();
    }

    public HelloWorldResource() {
    }

    @GET
    @Timed
    public String sayHello() {
        return "HelloWorld";
    }

//    @Path("/{name}")
//    @GET
//    public String getName(@PathParam("name") String name) {
//        return name;
//    }

//    @Path("/sleep/{time}")
//    @GET
//    public String getName(@PathParam("time") int time) throws InterruptedException {
//        Thread.sleep(time);
//        return "Finish";
//    }

//    @Path("/ram/5000/1024")
//    @GET
//    public String randomString() throws InterruptedException {
//       for(int i = 0; i <5000; i++){
//           RandomStringUtils.randomAscii(1024);
//       }
//        return "Finish";
//    }

//    @Path("/ram/50000/10240")
//    @GET
//    public String randomString() throws InterruptedException {
//       for(int i = 0; i <50000; i++){
//           RandomStringUtils.randomAscii(10240);
//       }
//        return "Finish";
//    }

//    @GET
//    @Path("/disk/5000/1024")
//    public String disk5k1k(){
//        for (int i = 0; i < 5000; i++) {
//            List<String> lines = Arrays.asList(RandomStringUtils.randomAlphanumeric(1024), "The second line");
//            java.nio.file.Path file = Paths.get("disk 5k 1k/5k1k " +i +".txt");
//            try {
//                Files.write(file, lines, Charset.forName("UTF-8"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return "ok";
//    }

//    @GET
//    @Path("/disk/50000/10240")
//    public String disk50k10k(){
//        for (int i = 0; i < 50000; i++) {
//            List<String> lines = Arrays.asList(RandomStringUtils.randomAlphanumeric(10240), "The second line");
//            java.nio.file.Path file = Paths.get("disk 50k 10k/50k10k " +i +".txt");
//            try {
//                Files.write(file, lines, Charset.forName("UTF-8"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return "ok";
//    }

//    @GET
//    @Path("/disk/50000/10240")
//    public String encryption(){
//        return "ok";
//    }

//    @GET
//    @Path("/json/{quantity}" )
//    public List<Person> getListJson(@PathParam("quantity") int quantity){
//        List<Person> list = new ArrayList<>();
//        Person person = new Person();
//        person.setAge(150);
//        person.setName("James Bone");
//        person.setSex("male");
//
//        for (int i= 0; i< quantity ; i++){
//            list.add(person);
//        }
//        demo a = new demo();
//        list = a.abc(12);
//        return list;
//    }

    public static boolean checkPrimeNumber(int n){
        int count = 0;
        for (int i = 0; i <= n ; i++){
            if(n%i==0)count++;
        }
        if(count == 2){
            return true;
        }else return false;
    }

}