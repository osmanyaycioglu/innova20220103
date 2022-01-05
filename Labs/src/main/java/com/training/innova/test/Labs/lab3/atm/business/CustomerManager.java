package com.training.innova.test.Labs.lab3.atm.business;

import java.util.List;

import com.training.innova.test.Labs.lab3.atm.common.IInputSource;
import com.training.innova.test.Labs.lab3.atm.common.LoginException;
import com.training.innova.test.Labs.lab3.atm.data.ICustomerStorage;
import com.training.innova.test.Labs.lab3.atm.models.Customer;

public class CustomerManager {

    private final ICustomerStorage customerStorage;

    public CustomerManager(final ICustomerStorage customerStorageParam) {
        this.customerStorage = customerStorageParam;
        this.customerStorage.init();
    }

    public List<ICustomerProcess> getCustomerProcesses() {
        return CustomerProcessFactory.getCustomerProcesses();
    }

    public void executeProcess(final ICustomerProcess iCustomerProcessLoc,
                               final Customer customerParam,
                               final IInputSource scannerParam) {
        iCustomerProcessLoc.customerTask()
                           .accept(customerParam,
                                   scannerParam);
    }


    public Customer login(final String username,
                          final String password) throws LoginException {
        Customer customerLoc = this.customerStorage.getCustomer(username);
        if (customerLoc == null) {
            throw new LoginException("Böyle bir user yok : " + username);

        }
        if (!password.equals(customerLoc.getPassword())) {
            throw new LoginException("Password eşleşmedi : " + username);
        }
        return customerLoc;
    }

    public Customer getCustomer(final String customerUsernameParam) {
        return this.customerStorage.getCustomer(customerUsernameParam);
    }

}
