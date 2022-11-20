package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.projection.IPurchaseItem;
import com.sha.springbootbookseller.repository.IPurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService {

    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<IPurchaseItem> findPurchasedItemOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
