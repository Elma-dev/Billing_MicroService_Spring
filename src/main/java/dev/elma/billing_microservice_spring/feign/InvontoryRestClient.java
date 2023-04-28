package dev.elma.billing_microservice_spring.feign;

import dev.elma.billing_microservice_spring.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InvontoryRestClient {
    @GetMapping(path = "/products")
    PagedModel<Product> produtsPage();
    @GetMapping(path="/products/{id}")
    Product findProductById(@PathVariable Long id);
}
