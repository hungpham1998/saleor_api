package com.saleor.saleor_api.service;

import com.saleor.saleor_api.mapper.MapperProduct;
import com.saleor.saleor_api.repo.RepoProduct;
import com.saleor.saleor_api.table.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerProduct {
    @Autowired
    RepoProduct repoProduct;

    public List<Product> GetAll()
    {
        return  repoProduct.findAll();
    }
    public Optional<Product> GetByID(Long id)
    {
        return  repoProduct.findById(id);
    }
    public Product InsertData(Product employee) { return repoProduct.save(employee); }

    public Product UpdateData(Product product) { return repoProduct.save(product); }

    public void Delete(Long id) { repoProduct.deleteById(id); }
}
