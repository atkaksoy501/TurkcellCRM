package com.turkcell.crm.catalogService.catalogService.business.concretes;

import com.turkcell.crm.catalogService.catalogService.business.abstracts.ProductService;
import com.turkcell.crm.catalogService.catalogService.business.dtos.requests.product.CreateProductRequest;
import com.turkcell.crm.catalogService.catalogService.business.dtos.responses.product.CreatedProductResponse;
import com.turkcell.crm.catalogService.catalogService.core.mapping.ModelMapperService;
import com.turkcell.crm.catalogService.catalogService.dataAccess.abstracts.ProductRepository;
import com.turkcell.crm.catalogService.catalogService.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {

    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;
    @Override
    public CreatedProductResponse add(CreateProductRequest createProductRequest) {
        Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
        product.setCreatedDate(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        return this.modelMapperService.forResponse().map(savedProduct, CreatedProductResponse.class);
    }

//    @Override
//    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest) {
//        Address address = addressRepository.findById(updateAddressRequest.getId()).orElse(null);
//        modelMapperService.forUpdate().map(updateAddressRequest, address);
//        address.setUpdatedDate(LocalDateTime.now());
//        Address savedAddress = addressRepository.save(address);
//        return this.modelMapperService.forResponse().map(savedAddress, UpdatedAddressResponse.class);
//    }
//
//    @Override
//    public void delete(int id) {
//        Address address = addressRepository.findById(id).orElse(null);
//        address.setActive(false);
//        address.setDeletedDate(LocalDateTime.now());
//        addressRepository.save(address);
//    }
//
//    @Override
//    public GetAddressResponseById getAddressById(int id) {
//        Address address = addressRepository.findById(id).orElse(null);
//        return this.modelMapperService.forResponse().map(address, GetAddressResponseById.class);
//    }
//
//    @Override
//    public List<GetAllAddressResponse> getAll() {
//        List<Address> addresses = addressRepository.findAll();
//        return addresses.stream().map(
//                address -> this.modelMapperService.forResponse().map(address, GetAllAddressResponse.class)
//        ).toList();
//    }
}
