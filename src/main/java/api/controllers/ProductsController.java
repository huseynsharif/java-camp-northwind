package api.controllers;

import business.abstracts.ProductService;
import core.utilities.results.DataResult;
import core.utilities.results.Result;
import entities.concretes.Product;
import entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){

        return this.productService.getAll();

    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){

        return this.productService.getProductWithCategoryDetails();

    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {

        return this.productService.add(product);

    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(String productName){

        return this.productService.getByProductName(productName);

    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){

        return this.productService.getAll(pageNo, pageSize);

    }

    @GetMapping("/getAllSortedDesc")
    public DataResult<List<Product>> getAllSorted(){

        return this.productService.getAllSorted();

    }

}
