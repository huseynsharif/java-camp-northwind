package com.example.northwind.dataAccess.abstracts;


import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>{

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("SELECT new com.example.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) FROM Category c inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

}