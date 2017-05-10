package com.nanda.samples.casandra;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nanda on 5/9/17.
 */
@Component
public class CasandraSample {

    @Autowired
    private CustomerRepository repository;

    public void performSampleOperation() {
        this.repository.deleteAll();

        // save a couple of customers
        this.repository.save(new Customer(UUIDs.timeBased(), "Alice", "Smith"));
        this.repository.save(new Customer(UUIDs.timeBased(), "Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : this.repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(this.repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : this.repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

    }

}
