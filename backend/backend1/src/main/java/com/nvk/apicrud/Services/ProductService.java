package com.nvk.apicrud.Services;

import com.nvk.apicrud.DTO.ProductRequest;
import com.nvk.apicrud.DTO.ProductResponse;
import com.nvk.apicrud.Entity.Product;
import com.nvk.apicrud.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts(String category) {
        List<Product> products = category == null || category.isBlank()
                ? productRepository.findAll()
                : productRepository.findByCategory(category);

        return products.stream().map(this::toResponse).toList();
    }

    public ProductResponse getProductById(Integer id) {
        Product product = findProduct(id);
        return toResponse(product);
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();
        applyRequest(product, request);
        return toResponse(productRepository.save(product));
    }

    public ProductResponse updateProduct(Integer id, ProductRequest request) {
        Product product = findProduct(id);
        applyRequest(product, request);
        return toResponse(productRepository.save(product));
    }

    public void deleteProduct(Integer id) {
        Product product = findProduct(id);
        productRepository.delete(product);
    }

    private Product findProduct(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    private void applyRequest(Product product, ProductRequest request) {
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setOldPrice(request.getOldPrice() == null ? request.getPrice() : request.getOldPrice());
        product.setImage(request.getImage());
        product.setStatus(request.getStatus() == null ? 1 : request.getStatus());
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getOldPrice(),
                product.getImage(),
                product.getStatus(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
