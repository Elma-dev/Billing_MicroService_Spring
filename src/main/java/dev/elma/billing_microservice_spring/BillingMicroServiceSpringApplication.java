package dev.elma.billing_microservice_spring;

import dev.elma.billing_microservice_spring.entities.Bill;
import dev.elma.billing_microservice_spring.entities.ProductItem;
import dev.elma.billing_microservice_spring.feign.CustomerRestClient;
import dev.elma.billing_microservice_spring.feign.InvontoryRestClient;
import dev.elma.billing_microservice_spring.models.Customer;
import dev.elma.billing_microservice_spring.models.Product;
import dev.elma.billing_microservice_spring.repositories.BillingRepository;
import dev.elma.billing_microservice_spring.repositories.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

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
        Product product= invontoryRestClient.findProductById(1L);
        System.out.println(product);
        System.out.println("----------------------------------------");

        Bill bill = Bill.builder()
                .billingDate(new Date()).customerID(1L).customer(customer).build();
        billingRepository.save(bill);
        ProductItem productItem = ProductItem.builder()
                .productID(1L).product(product).price(product.getPrice()).quantity(10).bill(bill).build();
        productItemRepository.save(productItem);

        System.out.println("---------------------------------------------");


    }
}
