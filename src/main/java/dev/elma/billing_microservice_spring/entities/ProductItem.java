package dev.elma.billing_microservice_spring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.elma.billing_microservice_spring.models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private double price;
    private int quantity;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private Long productID;
    @Transient
    private Product product;
}
