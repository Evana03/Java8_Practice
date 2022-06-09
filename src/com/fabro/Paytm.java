package com.fabro;

public class Paytm implements UPIPayment{
    @Override
    public String doPayment() {
        return "Paytm Payment "+UPIPayment.dateOfTransaction();
    }
}
