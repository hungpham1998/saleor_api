package com.saleor.saleor_api.service;

import com.saleor.saleor_api.repo.RepoSupplier;
import com.saleor.saleor_api.table.Supplier;
import com.saleor.saleor_api.utils.filterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SerSupplier {
    @Autowired
    RepoSupplier repoSupplier;

    Map<String,Object> response = new HashMap<>();

    public  Object save(Supplier payload){
        Supplier data = repoSupplier.save(payload);
        response.put("success", true);
        response.put("mesager", "ok");
        response.put("data",data);
        return response;
    }

    public void findByQuery(String query){
        Optional<Supplier> opSupplier = repoSupplier.findByPhoneContainingOrTitleContaining(query,query);
        filterObject.filter(opSupplier,"Khong tim thấy nhà cung cấp ");
    }

    public void findById(Long id){
        Optional<Supplier> opSupplier = repoSupplier.findById(id);
        filterObject.filter(opSupplier, "Khong tim thấy nhà cung cấp ");
    }

}
