package com.saleor.saleor_api.service;

import com.saleor.saleor_api.repo.RepoDetailOrder;
import com.saleor.saleor_api.repo.RepoOrders;
import com.saleor.saleor_api.table.OrderDetail;
import com.saleor.saleor_api.table.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SerOrderDetail {
    @Autowired
    RepoDetailOrder repoDetailOrder;

    public List<OrderDetail> GetAll()
    {
        return  repoDetailOrder.findAll();
    }
    public Optional<OrderDetail> GetByID(Long id)
    {
        return  repoDetailOrder.findById(id);
    }
    public OrderDetail InsertData(OrderDetail orderDetail) { return repoDetailOrder.save(orderDetail); }

    public OrderDetail UpdateData(OrderDetail orderDetail) { return repoDetailOrder.save(orderDetail); }

    public void Delete(Long id) { repoDetailOrder.deleteById(id); }
}
