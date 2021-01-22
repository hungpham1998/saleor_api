package com.saleor.saleor_api.control;

import com.saleor.saleor_api.data.Resp;
import com.saleor.saleor_api.service.SerCustomer;
import com.saleor.saleor_api.service.SerProduct;
import com.saleor.saleor_api.table.Customer;
import com.saleor.saleor_api.table.Product;
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
public class ContCustomer {
    @Autowired
    SerCustomer serCustomer;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Map<String, Object>> getAll()
    {
        Resp resp = new Resp();
        Map<String, Object> response =  new HashMap<>();
        try {
            List<Customer> data = serCustomer.GetAll();
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
            Optional<Customer> optional = serCustomer.GetByID(id);
            Customer customer = optional.get();
            response.put("data",customer);
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
    public ResponseEntity<?> Insert(@RequestBody Customer customer)
    {
        return new ResponseEntity<>(serCustomer.InsertData(customer), HttpStatus.OK);
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> Update(@RequestBody Customer customer)
    {
        return new ResponseEntity<>(serCustomer.UpdateData(customer), HttpStatus.OK);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> Delete(@RequestParam(value = "id", required =false) Long id) {
        Customer data= serCustomer.GetByID(id).orElse(null);
        if (data == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            serCustomer.Delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
