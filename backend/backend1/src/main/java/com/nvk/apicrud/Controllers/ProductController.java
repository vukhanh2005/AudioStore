package com.nvk.apicrud.Controllers;

import com.nvk.apicrud.DTO.ProductRequest;
import com.nvk.apicrud.DTO.ProductResponse;
import com.nvk.apicrud.Entity.Alter.AlterProduct;
import com.nvk.apicrud.Services.Alter.AlterProductService;
import com.nvk.apicrud.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"}, allowCredentials = "true")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
//    VTH an cut
    @GetMapping
    public ArrayList<AlterProduct> getAllProducts() throws Exception{
        return new AlterProductService().getAllProducts();
    }
//    VTH an cut
    @GetMapping("/category/{category}")
    public ArrayList<AlterProduct> getProductsByCategory(@PathVariable String category)throws Exception{
        return new AlterProductService().getProductsByCategory(category);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Integer id, @RequestBody ProductRequest request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return Map.of("message", "Product deleted successfully");
    }
}
