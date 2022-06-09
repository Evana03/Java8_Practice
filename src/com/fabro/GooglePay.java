package com.fabro;

import java.util.Random;

public class GooglePay implements UPIPayment {
    @Override
    public String doPayment() {
        return "google Payment "+UPIPayment.dateOfTransaction();
    }

    @Override
    public Double doScratchCard() {
        return   new Random().nextDouble();
    }
}
