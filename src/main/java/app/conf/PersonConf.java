package app.conf;

import app.pack.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("app.conf")
public class PersonConf {

    @Autowired
    SafeConf safeConf;

//    @Bean
//    public Person person1() {
//        return new Person("David Beckham",Arrays.asList(safeConf.safe1(),safeConf.safe2(),safeConf.safe5()));
//    }
//
//    @Bean
//    public Person person2() {
//        return new Person("Victoria Beckham",Arrays.asList(safeConf.safe2()));
//    }
//
//    @Bean
//    public Person person3() {
//        return new Person("Geri Halliwell",Arrays.asList(safeConf.safe2(),safeConf.safe3()));
//    }
//
//    @Bean
//    public Person person4() {
//        return new Person("Ryan Giggs",Arrays.asList(safeConf.safe4(),safeConf.safe5()));
//    }



}
