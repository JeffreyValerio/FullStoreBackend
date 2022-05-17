package com.fullstr.FullStore.service;

import com.fullstr.FullStore.dto.Purchase;
import com.fullstr.FullStore.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
