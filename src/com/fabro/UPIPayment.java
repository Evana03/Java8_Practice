package com.fabro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPayment {

    String doPayment();

   default Double doScratchCard(){
       double doub=new Random().nextDouble();
       System.out.println("double no is in Interface   "+ doub);
       return doub;
   }

   static String dateOfTransaction(){

       SimpleDateFormat sdf=new SimpleDateFormat("mm-dd-yyyy");

        return sdf.format(new Date());

   }


}
