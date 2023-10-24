package tech.marcelorsantos.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import tech.marcelorsantos.dto.ProductDTO;
import tech.marcelorsantos.entity.Product;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void updateProduct(Long id, ProductDTO dto){
        Product product = new Product();

        Optional<Product> productOpt = Product.findByIdOptional(id);

        if (productOpt.isEmpty()) {
            throw  new NullPointerException("Product not found");
        }

        product = productOpt.get();

        product.setNome(dto.getNome());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());

        product.persist();
    }

    @Transactional
    public void removeProduct(Long id){
        Optional<Product> productOpt = Product.findByIdOptional(id);

        if (productOpt.isEmpty()) {
            throw  new NullPointerException("Product not found");
        }

        Product product = productOpt.get();

        product.delete();
    }
}
