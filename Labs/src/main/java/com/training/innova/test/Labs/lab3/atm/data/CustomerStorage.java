package com.training.innova.test.Labs.lab3.atm.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.training.innova.test.Labs.lab3.atm.models.Customer;

public class CustomerStorage implements ICustomerStorage {

    private final Map<String, Customer> mapLoc = new ConcurrentHashMap<>();

    @Override
    public void init() {
    }

    @Override
    public Customer getCustomer(final String usernameParam) {
        return this.mapLoc.get(usernameParam);
    }

    @Override
    public void addCustomer(final Customer customerParam) {
        if (this.mapLoc.containsKey(customerParam.getUsername())) {
            throw new IllegalArgumentException("Bu kullanıcı şu anda var");
        }
        this.mapLoc.put(customerParam.getUsername(),
                        customerParam);

    }
}
