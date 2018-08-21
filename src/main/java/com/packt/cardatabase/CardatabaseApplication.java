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
    private CarRepository repository;

    @Autowired
    private OwnerRepository orepository;

    @Autowired
    private UserRepository urepository;

    // Run program method
    public static void main(String[] args)  {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
          // Add owner objects and save these to db
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");

            orepository.save(owner1);
            orepository.save(owner2);

            // Add car object with link to owners and save these to db
            repository.save(new Car("BMW", "M3", "Blue",
                    "ADF-1121", 2018, 59000, owner1));
            repository.save(new Car("Nissan", "Silvia", "White",
                    "MX-19891", 1991, 12000, owner2));
            repository.save(new Car("Toyota", "AE86", "White",
                    "TY-AE86", 1986, 6000, owner2));

            urepository.save(new User(
                    "user",
                    "$2a$04$8gIp48DabGnzWI.zrOBAGuTJxmDhALxHeTwqc1US9CFBQ94HQlMMe",
                    "USER"));
            urepository.save(new User(
                    "admin",
                    "$2a$04$8gIp48DabGnzWI.zrOBAGuTJxmDhALxHeTwqc1US9CFBQ94HQlMMe",
                    "ADMIN"));
        };
    }
}
