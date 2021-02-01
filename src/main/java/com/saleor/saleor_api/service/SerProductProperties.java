package com.saleor.saleor_api.service;

import com.saleor.saleor_api.dto.DtoProductProperties;
import com.saleor.saleor_api.mapper.MapperProductProperties;
import com.saleor.saleor_api.repo.RepoProduct;
import com.saleor.saleor_api.repo.RepoProductProperties;
import com.saleor.saleor_api.table.Product;
import com.saleor.saleor_api.table.ProductProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SerProductProperties {
    @Autowired
    RepoProductProperties repoProductProperties;
    @Autowired
    MapperProductProperties mapperProductProperties;
//    public List<DtoProductProperties> getAllProductProperties(Pageable pageable) {
//        List<ProductProperties> productProperties = repoProductProperties.findAllBy((java.awt.print.Pageable) pageable);
//        List<DtoProductProperties> dtoProductProperties = new ArrayList<>();
//        for (ProductProperties productProperties1 : productProperties) {
//            DtoProductProperties dtoProductProperties1 = mapperProductProperties.toDto(productProperties1);
//            dtoProductProperties.add(dtoProductProperties1);
//        }
//        return dtoProductProperties;
//    }
    public List<DtoProductProperties> getAllPropertiesByProductId(Product product) {
        List<ProductProperties> productProperties = repoProductProperties.findAllByProduct(product);
        List<DtoProductProperties> dtoProductProperties = new ArrayList<>();
        for (ProductProperties productProperties1 : productProperties) {
            DtoProductProperties dtoProductProperties1 = mapperProductProperties.toDto(productProperties1);
            dtoProductProperties.add(dtoProductProperties1);
        }
        return dtoProductProperties;

    }
    public List<ProductProperties> GetAll()
    {
        return  repoProductProperties.findAll();
    }

    public Optional<ProductProperties> GetByID(Long id)
    {
        return  repoProductProperties.findById(id);
    }

    public ProductProperties InsertData(ProductProperties productProperties) { return repoProductProperties.save(productProperties); }

    public ProductProperties UpdateData(ProductProperties productProperties) { return repoProductProperties.save(productProperties); }

    public void Delete(Long id) { repoProductProperties.deleteById(id); }
}
