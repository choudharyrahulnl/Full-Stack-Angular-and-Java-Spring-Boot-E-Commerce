package com.ecom.api.repositories;

import com.ecom.api.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("from Product p where p.category.id IN (?1)")
    List<Product> findProductByCategory(List<Long> id);

    // Similar to Like in SQL
    // We can use JPQL - @Query("from Product p where p.name like concat('%',?1,'%')")
    Page<Product> findProductByNameContaining(String name, Pageable pageable);

}
