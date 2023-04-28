package dev.elma.billing_microservice_spring;

import dev.elma.billing_microservice_spring.entities.Bill;
import dev.elma.billing_microservice_spring.feign.CustomerRestClient;
import dev.elma.billing_microservice_spring.feign.InvontoryRestClient;
import dev.elma.billing_microservice_spring.models.Customer;
import dev.elma.billing_microservice_spring.repositories.BillingRepository;
import dev.elma.billing_microservice_spring.repositories.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
@EnableFeignClients //Enable Feign Client
public class BillingMicroServiceSpringApplication implements CommandLineRunner {
    private BillingRepository billingRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private InvontoryRestClient invontoryRestClient;
    public static void main(String[] args) {
        SpringApplication.run(BillingMicroServiceSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------------------------------------");
        Customer customer=customerRestClient.findCostumerById(1L);
        System.out.println(customer);
        System.out.println(invontoryRestClient.findProductById(1L));
        System.out.println("----------------------------------------");
    }
}
