package com.training.innova.test.Labs.lab3.atm.business;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.training.innova.test.Labs.lab3.atm.models.Customer;

public class CustomerTaskImpl implements ICustomerProcess {

    private final Supplier<String>              menuProvider;
    private final BiConsumer<Customer, Scanner> customerTask;

    public CustomerTaskImpl(final Supplier<String> menuProviderParam,
                            final BiConsumer<Customer, Scanner> customerTaskParam) {
        super();
        this.menuProvider = menuProviderParam;
        this.customerTask = customerTaskParam;
    }

    @Override
    public Supplier<String> menuProvider() {
        return this.menuProvider;
    }

    @Override
    public BiConsumer<Customer, Scanner> customerTask() {
        return this.customerTask;
    }


}
