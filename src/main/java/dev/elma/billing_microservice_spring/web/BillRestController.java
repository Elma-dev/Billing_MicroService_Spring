package dev.elma.billing_microservice_spring.web;

import dev.elma.billing_microservice_spring.entities.Bill;
import dev.elma.billing_microservice_spring.feign.CustomerRestClient;
import dev.elma.billing_microservice_spring.feign.InvontoryRestClient;
import dev.elma.billing_microservice_spring.models.Customer;
import dev.elma.billing_microservice_spring.models.Product;
import dev.elma.billing_microservice_spring.repositories.BillingRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BillRestController {
    private BillingRepository billingRepository;
    private CustomerRestClient customerRestClient;
    private InvontoryRestClient invontoryRestClient;
    @GetMapping("/fullBill/{id}")
    Bill getBillwithId(@PathVariable(name="id") Long id){
        Bill bill =billingRepository.findById(id).get();

        Customer customer = customerRestClient.findCostumerById(bill.getCustomerID());
        bill.setCustomer(customer);

        bill.getProductItems().forEach(productItem -> {
            Product product = invontoryRestClient.findProductById(productItem.getProductID());
            productItem.setProduct(product);
        });

        return bill;
    }
}
