package com.saleor.saleor_api.control;

import com.saleor.saleor_api.payload.PayShop;
import com.saleor.saleor_api.payload.ResWareHouse;
import com.saleor.saleor_api.service.SerShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/shop")
public class ContShop {

    @Autowired
    SerShop  serShop;

    @RequestMapping(value = "/byid", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> getByID(@RequestParam(value = "id", required =false) Long id)
    {
        return new ResponseEntity<>(serShop.getShopById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/ins",method = RequestMethod.POST)
    @CrossOrigin(origins="*",maxAge = 3600)
    public ResponseEntity<?> insSent(@RequestBody PayShop prInput)
    {
        return new ResponseEntity<>(serShop.save(prInput),HttpStatus.OK);
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> deleteSent(@RequestParam Long id)
    {
        return new ResponseEntity<>(serShop.delete(id),HttpStatus.OK);
    }
}
