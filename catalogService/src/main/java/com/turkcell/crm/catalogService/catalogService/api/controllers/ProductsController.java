package com.turkcell.crm.catalogService.catalogService.api.controllers;

import com.turkcell.crm.catalogService.catalogService.business.abstracts.ProductService;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.product.CreateProductRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.product.UpdateProductRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.CreatedProductResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.GetAllProductsResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.GetProductByIdResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.UpdatedProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/productservice/api/v1/products")
public class ProductsController {
    private final ProductService productService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return productService.add(createProductRequest);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllProductsResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductByIdResponse getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedProductResponse update(@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.update(updateProductRequest);
    }

    @GetMapping("/isExist/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isExist(@PathVariable int id) {
        return productService.isExist(id);
    }
}
