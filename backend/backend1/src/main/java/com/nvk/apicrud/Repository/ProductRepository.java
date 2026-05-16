package com.nvk.apicrud.Repository;

import com.nvk.apicrud.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryIgnoreCase(String category);

    @Query(value = """
            SELECT *
            FROM products
            WHERE LOWER(REPLACE(category, ' ', '')) = LOWER(REPLACE(:category, ' ', ''))
            """, nativeQuery = true)
    List<Product> findByCategorySlug(@Param("category") String category);
}
