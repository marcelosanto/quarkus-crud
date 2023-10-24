package tech.marcelorsantos.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import tech.marcelorsantos.dto.ProductDTO;
import tech.marcelorsantos.entity.Product;

import java.util.List;

@ApplicationScoped
public class ProductService {
    public List<Product> productList(){
        return Product.listAll();
    }

    @Transactional
    public Product saveProduct(ProductDTO dto){
        Product product = new Product();

        product.setNome(dto.getNome());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
        product.persist();

        return product;
    }
}
