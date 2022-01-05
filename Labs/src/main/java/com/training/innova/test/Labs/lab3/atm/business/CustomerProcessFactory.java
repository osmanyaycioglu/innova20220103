package com.training.innova.test.Labs.lab3.atm.business;

import java.util.ArrayList;
import java.util.List;

import com.training.innova.test.Labs.lab3.atm.common.IInputSource;
import com.training.innova.test.Labs.lab3.atm.models.Customer;

public class CustomerProcessFactory {

    public static List<ICustomerProcess> getCustomerProcesses() {
        List<ICustomerProcess> customerProcessesLoc = new ArrayList<>();
        customerProcessesLoc.add(new CustomerTaskImpl(() -> "Para çekme",
                                                      CustomerProcessFactory::processWithdraw));
        customerProcessesLoc.add(new CustomerTaskImpl(() -> "Para yatırma",
                                                      (c,
                                                       s) -> {
                                                          System.out.println("Yatıracağınız miktar : ");
                                                          int depositLoc = s.nextInt();
                                                          int amountLoc = c.getAmount();
                                                          c.setAmount(amountLoc + depositLoc);
                                                      }));
        customerProcessesLoc.add(new CustomerTaskImpl(() -> "Hesap görüntüleme",
                                                      (c,
                                                       s) -> System.out.println("Hesabınızda : "
                                                                                + c.getAmount()
                                                                                + " TL var.")));
        customerProcessesLoc.add(new CustomerTaskImpl(() -> "Havale",
                                                      (c,
                                                       s) -> {
                                                          System.out.println("Havale miktarı : ");
                                                          int withdrawLoc = s.nextInt();
                                                          int amountLoc = c.getAmount();
                                                          c.setAmount(amountLoc - withdrawLoc);
                                                      }));
        customerProcessesLoc.add(new CustomerTaskImpl(() -> "Borsa",
                                                      (c,
                                                       s) -> {
                                                          System.out.println("Borsa miktarı : ");
                                                          int withdrawLoc = s.nextInt();
                                                          int amountLoc = c.getAmount();
                                                          c.setAmount(amountLoc - withdrawLoc);
                                                      }));

        return customerProcessesLoc;

    }

    public static void processWithdraw(final Customer c,
                                       final IInputSource s) {
        System.out.println("Çekeceğiniz miktar : ");
        int withdrawLoc = s.nextInt();
        int amountLoc = c.getAmount();
        c.setAmount(amountLoc - withdrawLoc);
    }
}
