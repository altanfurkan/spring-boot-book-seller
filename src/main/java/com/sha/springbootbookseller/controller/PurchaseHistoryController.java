package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.security.UserPrincipal;
import com.sha.springbootbookseller.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/purchase-history") //pre-path
public class PurchaseHistoryController {

    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;

    @PostMapping //api/purchase-history
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllPurchaseOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseHistoryService.findPurchasedItemOfUser(userPrincipal.getId()));
    }



}
