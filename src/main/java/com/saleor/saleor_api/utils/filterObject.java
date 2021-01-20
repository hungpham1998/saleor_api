package com.saleor.saleor_api.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class filterObject {
    public static Object filter(Optional data, String resp){
        Map<String,Object> response = new HashMap<>();
        if (!data.isPresent()) {
            response.put("success", false);
            response.put("masager", resp);
            return response;
        }
        response.put("masager", "ok");
        response.put("data", data.get());
        response.put("success", true);
        return response;
    }
}
