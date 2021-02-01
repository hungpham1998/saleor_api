package com.saleor.saleor_api.control;
import com.saleor.saleor_api.data.Resp;
import com.saleor.saleor_api.dto.DtoProduct;
import com.saleor.saleor_api.service.SerProduct;
import com.saleor.saleor_api.table.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/product")

public class ContProduct {
    @Autowired
    SerProduct serProduct;

    @RequestMapping(value="/ins",method = RequestMethod.POST)
    @CrossOrigin(origins="*",maxAge = 3600)
    public ResponseEntity<?> insSent(@RequestBody DtoProduct prInput)
    {
        return new ResponseEntity<>(serProduct.InsSent(prInput), HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Map<String, Object>> getAllProduct(Pageable pageable) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<DtoProduct> data = serProduct.getDtoProductPage(pageable);
            response.put("data", data);
            response.put("success", true);
            response.put("message", "Ok");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}