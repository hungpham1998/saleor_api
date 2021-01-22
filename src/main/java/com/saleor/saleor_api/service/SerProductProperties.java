package com.saleor.saleor_api.service;

import com.saleor.saleor_api.repo.RepoProduct;
import com.saleor.saleor_api.repo.RepoProductProperties;
import com.saleor.saleor_api.table.Product;
import com.saleor.saleor_api.table.ProductProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerProductProperties {
    @Autowired
    RepoProductProperties repoProductProperties;

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
