package com.saleor.saleor_api.control;

import com.saleor.saleor_api.service.SerProductCatogories;
import com.saleor.saleor_api.table.ProductCatogories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/catogories")
public class ContProductCatogories {

    @Autowired
    SerProductCatogories serProductCatogories;

    @RequestMapping(value = "/byid", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> getByID(@RequestParam(value = "id", required =false) Long id)
    {
        return new ResponseEntity<>(serProductCatogories.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/ins",method = RequestMethod.POST)
    @CrossOrigin(origins="*",maxAge = 3600)
    public ResponseEntity<?> insSent(@RequestBody ProductCatogories prInput)
    {
        return new ResponseEntity<>(serProductCatogories.save(prInput),HttpStatus.OK);
    }


    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> deleteSent(@RequestParam Long id)
    {
        return new ResponseEntity<>(serProductCatogories.delete(id),HttpStatus.OK);
    }
}
