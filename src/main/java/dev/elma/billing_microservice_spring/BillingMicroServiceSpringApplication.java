package dev.elma.billing_microservice_spring;

import dev.elma.billing_microservice_spring.entities.Bill;
import dev.elma.billing_microservice_spring.repositories.BillingRepository;
import dev.elma.billing_microservice_spring.repositories.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class BillingMicroServiceSpringApplication implements CommandLineRunner {
    private BillingRepository billingRepository;
    private ProductItemRepository productItemRepository;
    public static void main(String[] args) {
        SpringApplication.run(BillingMicroServiceSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Bill.builder()
                .billingDate(new Date()).customerID(Long.valueOf(1)).build();

    }
}
