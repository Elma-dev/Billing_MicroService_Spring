package dev.elma.billing_microservice_spring.web;

import dev.elma.billing_microservice_spring.entities.Bill;
import dev.elma.billing_microservice_spring.repositories.BillingRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BillRestController {
    private BillingRepository billingRepository;
    @GetMapping("/fullBill/{id}")
    Bill getBillwithId(@PathVariable(name="id") Long id){
        Bill bill =billingRepository.findById(id).get();
        return bill;
    }
}
