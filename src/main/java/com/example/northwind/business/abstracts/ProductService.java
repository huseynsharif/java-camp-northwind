package com.example.northwind.business.abstracts;

import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    DataResult<List<Product>> getAllSorted();

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

    DataResult<List<Product>>getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}