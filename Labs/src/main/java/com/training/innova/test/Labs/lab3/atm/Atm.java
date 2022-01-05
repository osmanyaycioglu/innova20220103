package com.training.innova.test.Labs.lab3.atm;

import java.util.List;

import com.training.innova.test.Labs.lab3.atm.business.CustomerManager;
import com.training.innova.test.Labs.lab3.atm.business.ICustomerProcess;
import com.training.innova.test.Labs.lab3.atm.common.IInputSource;
import com.training.innova.test.Labs.lab3.atm.common.IOutputSource;
import com.training.innova.test.Labs.lab3.atm.common.LoginException;
import com.training.innova.test.Labs.lab3.atm.data.CustomerStorage;
import com.training.innova.test.Labs.lab3.atm.data.ICustomerStorage;
import com.training.innova.test.Labs.lab3.atm.models.Customer;

public class Atm {

    ICustomerStorage                     customerStorageLoc = new CustomerStorage();
    CustomerManager                      customerManagerLoc;
    private final IOutputSource          outputSource;
    private final IInputSource           inputSource;
    private final List<ICustomerProcess> customerProcessesLoc;


    public Atm(final ICustomerStorage customerStorageLocParam,
               final IInputSource inputSourceParam,
               final IOutputSource outputSourceParam) {
        super();
        this.customerStorageLoc = customerStorageLocParam;
        this.inputSource = inputSourceParam;
        this.outputSource = outputSourceParam;
        this.customerManagerLoc = new CustomerManager(this.customerStorageLoc);
        this.customerProcessesLoc = this.customerManagerLoc.getCustomerProcesses();
    }

    public void start() {
        this.outputSource.writeLine("Bankamıza hoş geldiniz");
        root:
        while (true) {
            this.outputSource.writeLine("username:");
            String username = this.inputSource.nextString();
            this.outputSource.writeLine("password:");
            String password = this.inputSource.nextString();
            Customer customerLoc = null;
            try {
                customerLoc = this.customerManagerLoc.login(username,
                                                            password);
            } catch (LoginException eLoc) {
                System.out.println(eLoc.getMessage());
                continue root;
            }
            menu:
            while (true) {
                System.out.println(customerLoc.getName() + " " + customerLoc.getSurname() + " hoş geldiniz.");
                int i = 0;
                for (i = 0; i < this.customerProcessesLoc.size(); i++) {
                    ICustomerProcess cpLoc = this.customerProcessesLoc.get(i);
                    System.out.println((i + 1)
                                       + "-"
                                       + cpLoc.menuProvider()
                                              .get());
                }
                System.out.println(++i + "-Çıkış");
                System.out.println("seçiminiz : ");
                int nextIntLoc = this.inputSource.nextInt();
                if (nextIntLoc > this.customerProcessesLoc.size()) {
                    break root;
                }
                ICustomerProcess iCustomerProcessLoc = this.customerProcessesLoc.get(nextIntLoc - 1);
                this.customerManagerLoc.executeProcess(iCustomerProcessLoc,
                                                       customerLoc,
                                                       this.inputSource);
            }
        }

    }


}
