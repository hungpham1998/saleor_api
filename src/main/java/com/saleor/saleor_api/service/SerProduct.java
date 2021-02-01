package com.saleor.saleor_api.service;

//import com.saleor.saleor_api.mapper.MapperProduct;
import com.saleor.saleor_api.dto.DtoProduct;
import com.saleor.saleor_api.dto.DtoProductProperties;
import com.saleor.saleor_api.mapper.MapperProduct;
import com.saleor.saleor_api.mapper.MapperProductProperties;
import com.saleor.saleor_api.repo.RepoProduct;
import com.saleor.saleor_api.repo.RepoProductCatogories;
import com.saleor.saleor_api.repo.RepoProductProperties;
import com.saleor.saleor_api.repo.RepoUnit;
import com.saleor.saleor_api.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
//import sun.jvm.hotspot.debugger.Page;
////
////import java.awt.print.Pageable;
import java.util.*;

@Service
public class SerProduct {
    @Autowired
    RepoProduct repoProduct;
    @Autowired
    RepoProductCatogories repoProductCatogories;

    @Autowired
    RepoProductProperties repoProductProperties;
    @Autowired
    SerProductCatogories serProductCatogories;
    @Autowired
    SerProductProperties serProductProperties;
    @Autowired
    RepoUnit repoUnit;
    @Autowired
    MapperProduct mapperProduct;
    @Autowired
    MapperProductProperties mapperProductProperties;
//    @Autowired
//    DtoProductProperties dtoProductProperties;

//    public List<DtoProduct> getDtoProductPage(Pageable pageable) {
////        List<ProductProperties> listProperties = repoProductProperties.findAll();
//        List<Product> products = repoProduct.findAllBy(pageable);
//        List<DtoProduct> listProducts = new ArrayList<>();
//        for (Product product : products) {
//            DtoProduct dtoProduct = mapperProduct.toDto(product);
//            dtoProduct.setUnits(product.getUnits().getName());
//            dtoProduct.setProductCatogories_id(product.getProductCatogories().getId());
////            dtoProduct.setProductProperties(new ArrayList<>(serProductCatogories.getAllProductVariantionByProductId(product)));
//            List<DtoProductProperties> dtoProductProperties = new ArrayList<>();
//        }
//        return listProducts;
//    }

    public List<DtoProduct> getDtoProductPage(Pageable pageable){
        List<Product> products = repoProduct.findAllBy(pageable);
        List<DtoProduct> dtoProducts = new ArrayList<>();
        for (Product product : products) {
            DtoProduct dtoProduct = mapperProduct.toDto(product);
            dtoProduct.setUnits(product.getUnits().getName());
            dtoProduct.setProductCatogories_id(product.getProductCatogories().getId());
//            List<DtoProductProperties> dtoProductProperties = new ArrayList<>();
            dtoProduct.setProductProperties(new ArrayList<>(serProductProperties.getAllPropertiesByProductId(product)));

            dtoProducts.add(dtoProduct);
        }
        return dtoProducts;
    }
    // check sku khi them san pham moi
    private boolean isSkuExist(String sku) {
        List<Product> ListSku = repoProduct.findBySku(sku);

        if (ListSku != null && ListSku.size() > 0) {
            return true;
        }
        return false;
    }
    // check xem don vi tinh co ton tai hay khong
    private Units checkProductUnit(String unit) {
        List<Units> productUnitOpt = repoUnit.findByName(unit);
        if (productUnitOpt.size() > 0) {
            return productUnitOpt.get(0);
        }
        return null;
    }
    // check don vị tính nếu có thì trả ra nếu không thì thêm mới ròi trả ra
    public Units checkUnit(String unit){
        Units units = checkProductUnit(unit);
        if (units == null) {
            Units newUnits = new Units();
            newUnits.setName(unit);
            newUnits.setActive(true);
            units = repoUnit.save(newUnits);
        }
        return  units;
    }
    // tao mới hoặc  thuộc tính produc properties
    public List<ProductProperties> createProperties(List<ProductProperties> productProperties){
        List<ProductProperties> newProperties = new ArrayList<>();
        if (productProperties.size() > 0 && productProperties != null) {
            for (ProductProperties productProperties1 : productProperties) {
//                productProperties.set(true);
                ProductProperties newItem = repoProductProperties.save(productProperties1);
                newProperties.add(newItem);
            }
        }
        return newProperties;
    }
    public Object InsSent(DtoProduct dtoProduct) {
        Map<String, Object> response = new HashMap<>();
        try {

            Product product = new Product();
            // check sku
            if (isSkuExist(dtoProduct.getSku())) {
                response.put("message", "mã sku đã tồn tại!!");
                response.put("success", false);
                return response;
            }

            // tìm tên đơn vị tính nêu có thì trả ra
            String unit = dtoProduct.getUnits();
            Units units = checkUnit(unit);

//            Double price = formatStringToDouble(dtoProduct.getPrice());
//            Double reprice = formatStringToDouble(dtoProduct.getSaleprice());
//            product.setProductTag(productTags);
//            product.setUnits(units);
//            product.setShopInfo(shopInfo);
//            product.setSku(dtoProduct.getSku());
//            product.setSaleprice(reprice);
//            product.setPrice(price);
//            product.setImages(dtoProduct.getImages());
//            product.setContent(dtoProduct.getContent());
//            product.setTitle(dtoProduct.getTitle());
//            product.setIsActive(true);
//            Product product = new Product();
            product.setContent(dtoProduct.getContent());
            product.setCreatedDate(new Date());
            product.setBarcode(dtoProduct.getBarcode());
            product.setDescs(dtoProduct.getDescs());
            product.setName(dtoProduct.getName());
            product.setModifiedDate(new Date());
            product.setSku(dtoProduct.getSku());
            product.setPrice(dtoProduct.getPrice());
            product.setSalePrice(dtoProduct.getSalePrice());
            product.setQrcode(dtoProduct.getQrcode());
            product.setIsActive(dtoProduct.getIsActive());
            product.setQuantity_sold(dtoProduct.getQuantity_sold());
            product.setQuantity_current(dtoProduct.getQuantity_current());
            product.setImages(dtoProduct.getImages());
            List<ProductProperties> newProperties =  createProperties(product.getProductProperties());
            Product coproduct = repoProduct.save(product);
            product.setId(coproduct.getId());
            product.setProductProperties(newProperties);
            response.put("data", dtoProduct);
            response.put("success", true);
            return response;
        } catch (Exception ex) {
            response.put("data", ex);
            response.put("success", false);
            return response;
        }
    }

//
//    Map<String, Object> response = new HashMap<>();
//    public List<Product> GetAll()
//    {
//        return repoProduct.findAll();
//    }





    // check xem don vi tinh co ton tai hay khong
//    private Units checkProductUnit(String unit) {
//        List<Units> productUnitOpt = repoUnit.findByName(unit);
//        if (productUnitOpt.size() > 0) {
//            return productUnitOpt.get(0);
//        }
//        return null;
//    }
//    public Object InsSent(DtoProduct repose) {
//        try {
//            Product product = new Product();
//            product.setContent(repose.getContent());
//            product.setCreatedDate(new Date());
//            product.setBarcode(repose.getBarcode());
//            product.setDescs(repose.getDescs());
//            product.setName(repose.getName());
//            product.setModifiedDate(new Date());
//            product.setSku(repose.getSku());
//            product.setPrice(repose.getPrice());
//            product.setSalePrice(repose.getSalePrice());
//            product.setQrcode(repose.getQrcode());
//            product.setIsActive(repose.getIsActive());
//            product.setQuantity_sold(repose.getQuantity_sold());
//            product.setQuantity_current(repose.getQuantity_current());
//            product.setImages(repose.getImages());
//            Optional<ProductCatogories> productCatogories = repoProductCatogories.findById(repose.getProductCatogories_id());
//            if (!productCatogories.isPresent()) {
//                response.put("success", false);
//                return response;
//            }
//            // tìm tên đơn vị tính nêu có thì trả ra
//            String unit = repose.getUnit_name();
//            Units units = checkProductUnit(unit);
//            if (units == null) {
//                Units newUnits = new Units();
//                newUnits.setName(unit);
//                newUnits.setActive(true);
//                units = repoUnit.save(newUnits);
//            }
//            product.setProductCatogories(productCatogories.get());
////            List<Units> listUnit = repoUnit.findBy();
////            product.setUnits(un);
//            Product newProd =  repoProduct.save(product);
//            repose.setId(newProd.getId());
//            response.put("data", repose);
//            response.put("success", true);
//            return response;
//        } catch (Exception e) {
//            response.put("success", false);
//            response.put("mesager", e.getMessage());
//            return response;
//        }
//    }
}
