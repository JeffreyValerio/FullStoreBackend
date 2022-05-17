package com.fullstr.FullStore.dto;

import java.util.Set;

import com.fullstr.FullStore.entity.*;

import lombok.Data;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}