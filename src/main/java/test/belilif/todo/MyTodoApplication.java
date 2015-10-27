package test.belilif.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // une version embarquée de tomcat sera lancée
public class MyTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTodoApplication.class, args);
    }
}
