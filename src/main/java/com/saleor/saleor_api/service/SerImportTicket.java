package com.saleor.saleor_api.service;

import com.saleor.saleor_api.dto.DTOImportTicket;
import com.saleor.saleor_api.dto.DTOImportTicketDetail;
import com.saleor.saleor_api.mapper.MapperImportTicket;
import com.saleor.saleor_api.mapper.MapperImportTicketDetail;
import com.saleor.saleor_api.repo.*;
import com.saleor.saleor_api.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SerImportTicket {

    @Autowired
    RepoImportTicket repoImportTicket;

    @Autowired
    MapperImportTicket mapperImportTicket;

    @Autowired
    MapperImportTicketDetail mapperImportTicketDetail;

    @Autowired
    RepoSupplier repoSupplier;

    @Autowired
    RepoProduct repoProduct;

    @Autowired
    RepoUnit repoUnit;

    @Autowired
    RepoImportTicketDetail repoImportTicketDetail;

    Map<String, Object> response = new HashMap<>();

    public Object  InsSent(DTOImportTicket repose){
        try{
            repose.setCreatedDate(new Date());
            ImportTicket orderTicket = null;
            orderTicket  = mapperImportTicket.toEntity(repose);
            Optional<Supplier> opSupplier = repoSupplier.findById(repose.getSupplierId());
            if(!opSupplier.isPresent()){
                response.put("success", false);
                return response;
            }
            List<Units>  listUnit = repoUnit.findAll();
            List<DTOImportTicketDetail> orderTicketDetail = repose.getTicketDetailList();
            ImportTicket newOrder = new ImportTicket();
            orderTicket.setSupplier(opSupplier.get());
            newOrder = repoImportTicket.save(orderTicket);
            repose.setId(newOrder.getId());
            repose.setSupplierTitle(opSupplier.get().getTitle());
            List<Product> listProduct = repoProduct.findAll();
            ImportTicketDetail newOrderDetail = null;
            for(DTOImportTicketDetail item : orderTicketDetail){
                newOrderDetail = mapperImportTicketDetail.toEntity(item);
                for(Product product: listProduct){
                    if(item.getProductId().equals(product.getId())){
                        newOrderDetail.setSku(product.getSku());
                        newOrderDetail.setProduct(product);
                    }
                }
                for(Units unit : listUnit){
                    if(item.getUnitId().equals(unit.getId())){
                        item.setUnitTitle(unit.getName());
                    }
                }
                newOrderDetail.setImportTicket(newOrder);
                newOrderDetail = repoImportTicketDetail.save(newOrderDetail);
                item.setId(newOrderDetail.getId());
                item.setSku(newOrderDetail.getSku());
                item.setProductTitle(newOrderDetail.getProduct().getName());
            }
            response.put("data", repose);
            response.put("success", true);
            return response;
        }
        catch(Exception e){
            response.put("success", false);
            response.put("mesager", e.getMessage());
            return response;
        }
    }
}
