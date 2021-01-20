package com.saleor.saleor_api.service;

import com.saleor.saleor_api.payload.PayShop;
import com.saleor.saleor_api.repo.RepoShop;
import com.saleor.saleor_api.repo.RepoUser;
import com.saleor.saleor_api.table.Shop;
import com.saleor.saleor_api.table.User;
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
    Map<String, Object> response = new HashMap<>();

    public Object getShopById(Long id){
        Optional<Shop> opShop = repoShop.findById(id);
        if(!opShop.isPresent()){
            response.put("success", false);
            response.put("masager", "khong tim thay  shop");
            return response;
        }
        response.put("success", false);
        response.put("masager", "ok");
        response.put("data", opShop.get());
        return response;
    }

    public Object save(PayShop payShop){
        Long userId =  payShop.getUserId();
        Optional<User> opUser = repoUser.findById(userId);
        if(!opUser.isPresent()) {
            response.put("success", false);
            response.put("masager", "khong tim thay user id");
            return response;
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
        response.put("success", true);
        response.put("masager", "ok");
        response.put("data",newShop);
        return response;
    }

}
