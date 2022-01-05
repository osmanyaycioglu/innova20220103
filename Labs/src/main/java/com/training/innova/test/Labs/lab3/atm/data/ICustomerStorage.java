package com.training.innova.test.Labs.lab3.atm.data;

import com.training.innova.test.Labs.lab3.atm.models.Customer;

public interface ICustomerStorage {

    void init();

    Customer getCustomer(String username);

    void addCustomer(Customer customerParam);

}
