package com.nanda.samples;

import com.nanda.samples.casandra.CasandraSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaCasandraApplication implements CommandLineRunner {

    @Autowired
    private CasandraSample casandraSample;

    @Override
    public void run(String... args) throws Exception {
        this.casandraSample.performSampleOperation();
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaCasandraApplication.class, args);
    }
}
