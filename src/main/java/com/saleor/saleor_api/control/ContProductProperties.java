package com.saleor.saleor_api.control;

import com.saleor.saleor_api.data.Resp;
import com.saleor.saleor_api.service.SerProduct;
import com.saleor.saleor_api.service.SerProductProperties;
import com.saleor.saleor_api.table.Product;
import com.saleor.saleor_api.table.ProductProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/properties")
public class ContProductProperties {
    @Autowired
    SerProductProperties serProductProperties;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Map<String, Object>> getAll()
    {
        Resp resp = new Resp();
        Map<String, Object> response =  new HashMap<>();
        try {
            List<ProductProperties> data = serProductProperties.GetAll();
            resp.setSuccess(true);
            resp.setMsg("Ok");
            resp.setData(data);
            response.put("data",resp.getData());
            response.put("success",resp.getSuccess());
            response.put("message", resp.getMsg());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            resp.setSuccess(false);
            response.put("success",resp.getSuccess());
            response.put("error", e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/byid", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Map<String, Object>> getByID(@RequestParam(value = "id", required =false) Long id)
    {
        Map<String, Object> response =  new HashMap<>();
        try {
            Optional<ProductProperties> optional = serProductProperties.GetByID(id);
            ProductProperties productProperties = optional.get();
            response.put("data",productProperties);
            response.put("success",true);
            response.put("message", "Ok");
            return new ResponseEntity<>(response,HttpStatus.OK);

        }
        catch (Exception e){
            response.put("success",false);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/ins", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> Insert(@RequestBody ProductProperties productProperties)
    {
        return new ResponseEntity<>(serProductProperties.InsertData(productProperties), HttpStatus.OK);
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> Update(@RequestBody ProductProperties productProperties)
    {
        return new ResponseEntity<>(serProductProperties.UpdateData(productProperties), HttpStatus.OK);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> Delete(@RequestParam(value = "id", required =false) Long id) {
        ProductProperties data= serProductProperties.GetByID(id).orElse(null);
        if (data == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            serProductProperties.Delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
