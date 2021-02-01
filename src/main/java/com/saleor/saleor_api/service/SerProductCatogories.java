package com.saleor.saleor_api.service;

import com.saleor.saleor_api.repo.RepoProductCatogories;
import com.saleor.saleor_api.table.ProductCatogories;
import com.saleor.saleor_api.table.ProductProperties;
import com.saleor.saleor_api.table.User;
import com.saleor.saleor_api.table.WareHouse;
import com.saleor.saleor_api.utils.filterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SerProductCatogories {

    @Autowired
    RepoProductCatogories repoProductCatogories;

    @Autowired
    SerUser serUser;

    Map<String,Object> reponse = new HashMap<>();
    public Optional<ProductCatogories> GetByID(Long id)
    {
        return  repoProductCatogories.findById(id);
    }
    public Object save(ProductCatogories response){
        try{
            ProductCatogories newdata = repoProductCatogories.save(response);
            reponse.put("data", newdata);
            reponse.put("success", true);
            reponse.put("mesager", "ok");
            return reponse;
        }
        catch (Exception e){
            reponse.put("success", false);
            reponse.put("mesager", e.getMessage());
            return  reponse;
        }
    }

    public Object findById(Long id){
        try {
            Optional<ProductCatogories> opCatogories = repoProductCatogories.findById(id);
            Object data = filterObject.filter(opCatogories, "Khong tim thấy danh muc san pham ");
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
            Optional<ProductCatogories> opCatogories = repoProductCatogories.findById(id);
            if(!opCatogories.isPresent()){
                reponse.put("success", false);
                reponse.put("mesager","Khong tim thấy danh muc san pham ");
                return reponse;
            }
            repoProductCatogories.deleteById(id);
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
