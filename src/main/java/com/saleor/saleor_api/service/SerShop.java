package com.saleor.saleor_api.service;

import com.saleor.saleor_api.payload.PayShop;
import com.saleor.saleor_api.repo.RepoShop;
import com.saleor.saleor_api.repo.RepoUser;
import com.saleor.saleor_api.table.Shop;
import com.saleor.saleor_api.table.User;
import com.saleor.saleor_api.utils.filterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SerShop {
    @Autowired
    RepoShop repoShop;

    @Autowired
    RepoUser repoUser;
    Map<String, Object> reponse = new HashMap<>();


    public Object getShopById(Long id){
        try {
            Optional<Shop> opShop = repoShop.findById(id);
            Object data =  filterObject.filter(opShop, "Khong tim thấy shop ");
            return data;
        }
        catch (Exception e){
            reponse.put("success", false);
            reponse.put("mesager",e.getMessage());
            return reponse;
        }
    }

    public Object save(PayShop payShop){
        Long userId =  payShop.getUserId();
        Optional<User> opUser = repoUser.findById(userId);
        if(!opUser.isPresent()) {
            reponse.put("success", false);
            reponse.put("masager", "khong tim thay user id");
            return reponse;
        }
        Shop data = new Shop();
        data.setUser(opUser.get());
        data.setEmail(payShop.getEmail());
        data.setImage(payShop.getImage());
        data.setPhone(payShop.getPhone());
        data.setManager(payShop.getManager());
        data.setDistrict_id(payShop.getDistrict_id());
        data.setTitle(payShop.getTitle());
        data.setProvince_id(data.getProvince_id());
        data.setWard_id(payShop.getWard_id());
        Shop newShop = repoShop.save(data);
        reponse.put("success", true);
        reponse.put("masager", "ok");
        reponse.put("data",newShop);
        return reponse;
    }

    public Object delete(Long id){
        try{
            Optional<Shop> opShop = repoShop.findById(id);
            if (opShop.isPresent()) {
                repoShop.deleteById(id);
                reponse.put("success", true);
                reponse.put("mesager", "xoa thanh cong");
            } else {
                reponse.put("success", false);
                reponse.put("mesager", "khong tim thay id kho");
            }
            return reponse;
        }
        catch (Exception e){
            reponse.put("success", false);
            reponse.put("mesager",e.getMessage());
            return reponse;
        }
    }

}
