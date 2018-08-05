package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {

    // Inject repositiories
    @Autowired
    private CarReposity reposity;

    @Autowired
    private OwnerReposity oreposity;

    @Autowired
    private UserRepository urepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
          // Add owner objects and save these to db
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");

            oreposity.save(owner1);
            oreposity.save(owner2);

            // Add car object with link to owners and save these to db
            reposity.save(new Car("BMW", "M3", "Blue",
                    "ADF-1121", 2018, 59000, owner1));
            reposity.save(new Car("Nissan", "Silvia", "White",
                    "MX-19891", 1991, 12000, owner2));
            reposity.save(new Car("Toyota", "AE86", "White",
                    "TY-AE86", 1986, 6000, owner2));

            urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
            urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
        };
    }
}
