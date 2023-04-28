package dev.elma.billing_microservice_spring.repositories;

import dev.elma.billing_microservice_spring.entities.Bill;
import dev.elma.billing_microservice_spring.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
    List<ProductItem> findProductItemByBillId(Long id);
}
