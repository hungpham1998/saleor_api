package com.saleor.saleor_api.control;

import com.saleor.saleor_api.dto.DTOImportTicket;
import com.saleor.saleor_api.payload.PayShop;
import com.saleor.saleor_api.service.SerImportTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/importproduct")
public class ContImportTicket {
    @Autowired
    SerImportTicket serImportTicket;



    @RequestMapping(value="/ins",method = RequestMethod.POST)
    @CrossOrigin(origins="*",maxAge = 3600)
    public ResponseEntity<?> insSent(@RequestBody DTOImportTicket prInput)
    {
        return new ResponseEntity<>(serImportTicket.InsSent(prInput), HttpStatus.OK);
    }


}
