package com.training.innova.test.Labs.lab3.atm;

import java.util.Scanner;

import com.training.innova.test.Labs.lab3.atm.common.IInputSource;
import com.training.innova.test.Labs.lab3.atm.common.IOutputSource;
import com.training.innova.test.Labs.lab3.atm.common.InputSourceImpl;
import com.training.innova.test.Labs.lab3.atm.common.OutputSourceImpl;
import com.training.innova.test.Labs.lab3.atm.data.CustomerStorage;
import com.training.innova.test.Labs.lab3.atm.models.Customer;

public class RunAtm {

    public static void main(final String[] args) {
        CustomerStorage customerStorageLoc = new CustomerStorage();
        customerStorageLoc.addCustomer(new Customer().setUsername("osmany")
                                                     .setName("osman")
                                                     .setSurname("yaycıoğlu")
                                                     .setAmount(1000)
                                                     .setPassword("1234"));
        try (Scanner scannerLoc = new Scanner(System.in)) {
            IInputSource inputSourceLoc = new InputSourceImpl(scannerLoc);
            IOutputSource outputSourceLoc = new OutputSourceImpl();
            Atm atmLoc = new Atm(customerStorageLoc,
                                 inputSourceLoc,
                                 outputSourceLoc);
            atmLoc.start();
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
    }
}
