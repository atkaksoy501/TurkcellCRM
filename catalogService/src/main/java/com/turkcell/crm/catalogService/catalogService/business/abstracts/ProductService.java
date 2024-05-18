package com.turkcell.crm.catalogService.catalogService.business.abstracts;



import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.product.CreateProductRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.product.UpdateProductRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.CreatedProductResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.GetAllProductsResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.GetProductByIdResponse;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.UpdatedProductResponse;

import java.util.List;

public interface ProductService {

    CreatedProductResponse add(CreateProductRequest createProductRequest);
//    List<GetAllProductsResponse> getAll();
//    GetProductByIdResponse getById(int id);
//    UpdatedProductResponse update(UpdateProductRequest updateProductRequest);
//    void delete(int id);
}
