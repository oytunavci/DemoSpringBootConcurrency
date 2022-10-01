package app.conf;

import app.pack.SafeDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("app")
public class SafeConf {

//    @Autowired
//    public SafeDeposit safe1() {
//        return new SafeDeposit(1, 300.0, 100.0, 2000.0, 50.0);
//    }
//
//    @Bean
//    public SafeDeposit safe2() {
//        return new SafeDeposit(2, 0.0, 5000.0, 1500.0, 10.0);
//    }
//
//    @Bean
//    public SafeDeposit safe3() {
//        return new SafeDeposit(3, 100.0, 800.0, 600.0, 3.0);
//    }
//
//    @Bean
//    public SafeDeposit safe4() {
//        return new SafeDeposit(4, 500.0, 500.0, 2000.0, 0.0);
//    }
//
//    @Bean
//    public SafeDeposit safe5() {
//        return new SafeDeposit(5, 0.0, 0.0, 1000.0, 0.0);
//    }
}
