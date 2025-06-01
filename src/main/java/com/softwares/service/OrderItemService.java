package com.softwares.service;

import com.softwares.models.OrderItem;

public interface OrderItemService {

    OrderItem getOrderItemById(Long id) throws Exception;
}
