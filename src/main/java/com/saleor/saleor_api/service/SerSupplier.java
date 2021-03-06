package com.saleor.saleor_api.service;

import com.saleor.saleor_api.repo.RepoSupplier;
import com.saleor.saleor_api.table.Supplier;
import com.saleor.saleor_api.table.WareHouse;
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

    Map<String,Object> reponse = new HashMap<>();

    public  Object save(Supplier payload){
        try {
            Supplier data = repoSupplier.save(payload);
            reponse.put("success", true);
            reponse.put("mesager", "ok");
            reponse.put("data", data);
            return reponse;
        }
        catch (Exception e){
            reponse.put("success", false);
            reponse.put("mesager",e.getMessage());
            return reponse;
        }

    }

    public Object findByQuery(String query){
        try {
            Optional<Supplier> opSupplier = repoSupplier.findByPhoneContainingOrTitleContaining(query, query);
                Object data = filterObject.filter(opSupplier, "Khong tim thấy nhà cung cấp ");
                return data;
        }
        catch (Exception e){
            reponse.put("success", false);
            reponse.put("mesager",e.getMessage());
            return reponse;
        }
    }

    public Object findById(Long id){
        try {
            Optional<Supplier> opSupplier = repoSupplier.findById(id);
            Object data = filterObject.filter(opSupplier, "Khong tim thấy nhà cung cấp ");
            return data;
        }
        catch (Exception e){
            reponse.put("success", false);
            reponse.put("mesager",e.getMessage());
            return reponse;
        }
    }

    public Object delete(Long id){
        try{
            Optional<Supplier> opSupplier = repoSupplier.findById(id);
            if(!opSupplier.isPresent()){
                reponse.put("success", false);
                reponse.put("mesager","khong tim thay id kho ");
                return reponse;
            }
            repoSupplier.deleteById(id);
            reponse.put("success", true);
            reponse.put("mesager","xoa thanh cong");
            return reponse;
        }
        catch (Exception e){
            reponse.put("success", false);
            reponse.put("mesager",e.getMessage());
            return reponse;
        }
    }

}
