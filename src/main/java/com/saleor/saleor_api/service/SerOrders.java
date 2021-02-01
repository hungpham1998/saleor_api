package com.saleor.saleor_api.service;

import com.saleor.saleor_api.repo.RepoOrders;
import com.saleor.saleor_api.table.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SerOrders {
    @Autowired
    RepoOrders repoOrders;

    public List<Orders> GetAll()
    {
        return  repoOrders.findAll();
    }
    public Optional<Orders> GetByID(Long id)
    {
        return  repoOrders.findById(id);
    }
    public Orders InsertData(Orders orders) { return repoOrders.save(orders); }

    public Orders UpdateData(Orders orders) { return repoOrders.save(orders); }

    public void Delete(Long id) { repoOrders.deleteById(id); }

//    public Object ()
}
