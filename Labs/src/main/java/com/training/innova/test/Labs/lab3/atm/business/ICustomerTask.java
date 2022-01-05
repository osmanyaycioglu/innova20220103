package com.training.innova.test.Labs.lab3.atm.business;

import com.training.innova.test.Labs.lab3.atm.common.IInputSource;
import com.training.innova.test.Labs.lab3.atm.models.Customer;

@FunctionalInterface
public interface ICustomerTask {

    void execute(Customer customerParam,
                 IInputSource scannerParam);
}
