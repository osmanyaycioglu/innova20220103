package com.training.innova.test.Labs.lab3.atm.business;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.training.innova.test.Labs.lab3.atm.common.IInputSource;
import com.training.innova.test.Labs.lab3.atm.models.Customer;

public class CustomerTaskImpl implements ICustomerProcess {

    private final Supplier<String>                   menuProvider;
    private final BiConsumer<Customer, IInputSource> customerTask;

    public CustomerTaskImpl(final Supplier<String> menuProviderParam,
                            final BiConsumer<Customer, IInputSource> customerTaskParam) {
        super();
        this.menuProvider = menuProviderParam;
        this.customerTask = customerTaskParam;
    }

    @Override
    public Supplier<String> menuProvider() {
        return this.menuProvider;
    }

    @Override
    public BiConsumer<Customer, IInputSource> customerTask() {
        return this.customerTask;
    }


}
