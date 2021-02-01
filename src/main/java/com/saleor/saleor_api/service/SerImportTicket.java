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
            ImportTicket orderTicket = new ImportTicket();

            List<Product> listProduct = repoProduct.findBy();

            orderTicket.setCreateBy(repose.getCreateBy());

            orderTicket.setCreatedDate(new Date());

            orderTicket.setOrderCode(repose.getOrderCode());

            orderTicket.setModifiedBy(repose.getModifiedBy());

            orderTicket.setNote(repose.getNote());

            orderTicket.setModifiedBy(repose.getModifiedBy());

            orderTicket.setPhone(repose.getPhone());

            orderTicket.setShipCode(repose.getShipCode());

            orderTicket.setTitle(repose.getTitle());

            orderTicket.setTotal(repose.getTotal());

            Optional<Supplier> opSupplier = repoSupplier.findById(repose.getSupplierId());

            if(!opSupplier.isPresent()){
                response.put("success", false);
                response.put("mesager","không tìm thấy nhà cung cấp ");
                return response;
            }

            List<Units>  listUnit = repoUnit.findBy();

            List<DTOImportTicketDetail> orderTicketDetail = repose.getImportTicketDetails();

            ImportTicket newOrder = new ImportTicket();

            orderTicket.setSupplier(opSupplier.get());

            newOrder = repoImportTicket.save(orderTicket);

            repose.setId(newOrder.getId());

            repose.setSupplierTitle(opSupplier.get().getTitle());

            for(DTOImportTicketDetail item : orderTicketDetail){
                ImportTicketDetail newOrderDetail = new ImportTicketDetail();
                newOrderDetail.setImportPrice(item.getImportPrice());
                newOrderDetail.setTotalPrice(item.getTotalPrice());
                newOrderDetail.setTotalQuantity(item.getTotalQuantity());
                newOrderDetail.setUnitId(item.getUnitId());
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
            response.put("mesager","ok");
            return response;
        }
        catch(Exception e){
            response.put("success", false);
            response.put("mesager", e.getMessage());
            return response;
        }
    }


    public Object findById(Long id){
        Optional<ImportTicket> opImport = repoImportTicket.findById(id);
        if(!opImport.isPresent()){
            response.put("success", false);
            response.put("mesager","không tìm thấy phiếu nhập ");
            return response;
        }
//        DTOImportTicket data = new DTOImportTicket();
//        List<DTOImportTicketDetail> listImport = new ArrayList<>();
//        List<D>
        return response;
    }

    public DTOImportTicket convertImportTicket(ImportTicket importTicket, List<ImportTicketDetail> listImportDetail){
        DTOImportTicket data = new DTOImportTicket();
        data = mapperImportTicket.toDto(importTicket);
        data.setSupplierTitle(importTicket.getSupplier().getTitle());
//        data.setModifiedBy(importTicket.getModifiedBy());
//        data.setCreatedDate(importTicket.getCreatedDate());
//        data.setPhone(importTicket.getPhone());
//        data.se
        return data;
    }

}
