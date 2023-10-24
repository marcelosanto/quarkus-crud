package tech.marcelorsantos.service;

import jakarta.enterprise.context.ApplicationScoped;
import tech.marcelorsantos.entity.Product;

import java.util.List;

@ApplicationScoped
public class ProductService {
    public List<Product> productList(){
        return Product.listAll();
    }
}
