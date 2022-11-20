package com.sha.springbootbookseller.projection;

import java.time.LocalTime;

public interface IPurchaseItem {
    String getTitle();
    Double getPrice();
    LocalTime getPurchaseTime();


}
