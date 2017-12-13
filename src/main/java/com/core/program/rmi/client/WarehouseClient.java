package com.core.program.rmi.client;

import com.core.program.rmi.download.Warehouse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

/**
 * Created by wm on 17-11-30.
 */
public class WarehouseClient {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context namingContext = new InitialContext();
        System.out.println("RMI registry bindings: ");
        Enumeration<NameClassPair> e = namingContext.list("rmi://localhost:6600/");
        while(e.hasMoreElements()) {
            System.out.println(e.nextElement().getName());
        }

        String url = "rmi://localhost:6600/central_warehouse";
        Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);

        String descr = "Blackwell Toaster";
        double price = centralWarehouse.getPrice(descr);
        System.out.println(descr + ": " + price);
    }
}
