package dev.elma.billing_microservice_spring.feign;

import dev.elma.billing_microservice_spring.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Consumation Of MS API
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/customers")
    PagedModel<Customer> CustomersPage();
    @GetMapping(path="/customers/{id}")
    Customer findCostumerById(@PathVariable(name = "id") Long id);

}
