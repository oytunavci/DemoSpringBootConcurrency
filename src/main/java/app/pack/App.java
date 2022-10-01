package app.pack;

import app.conf.PersonConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("app.conf")
public class App implements CommandLineRunner {

    @Autowired
    private PersonHandler personHandler;

    private static Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
//        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(App.class, args);
//        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {


        ApplicationContext context = new ClassPathXmlApplicationContext("safeandpersonconf.xml");

        List<Person> personList = (List<Person>) context.getBean("personList");

        personList.stream().forEach(
                p->
                {
                    System.out.println(Thread.currentThread().getId()+"\tperson being handled :"+p.getName());
                    personHandler.handlePerson(p);
                }
        );

        Thread.sleep(5000);


        personList.stream().forEach(
                p-> {
                    System.out.println(p.getName()+" "+p.getTotalAssetInUSD());
                    }
        );


        //safe1: 300 + 100*0.9 + 2000*1.1 + 50*50 = 300 + 90 + 2200 + 2500 = 5090
        //safe2: 0 + 5000*0.9 + 1500*1.1 + 10*50 = 0 + 4500 + 1650 + 500 = 6650
        //safe3: 100 + 800*0.9 + 600*1.1 + 3*50 = 100 + 720 + 660 + 150 = 1630
        //safe4: 500 + 500*0.9 + 2000*1.1 + 0*50 = 500 + 450 + 2200 + 0 = 3150
        //safe5: 0 + 0*0.9 + 1000*1.1 + 0*50 = 0 + 0 + 1100 + 0 = 1100

        Double wholeTotal = personList.stream()
                .mapToDouble(x -> x.getTotalAssetInUSD())
                .sum();

        System.out.println("Whole total should be: 17520");
        System.out.println("calculated total is: " + wholeTotal);



    }
}