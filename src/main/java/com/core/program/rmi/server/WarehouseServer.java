package com.core.program.rmi.server;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by wm on 17-11-30.
 */
public class WarehouseServer {
    public static void main(String[] args) throws RemoteException, NamingException {
        System.out.println("Constructing server implementation...");
        WarehouseImpl centralWarehouse = new WarehouseImpl();
        System.out.println("register port...");
        LocateRegistry.createRegistry(6600);
        System.out.println("Bingding server implementation to registry...");
        Context namingContext = new InitialContext();
        namingContext.bind("rmi://localhost:6600/central_warehouse", centralWarehouse);
        System.out.println("Waiting for invocations from clients...");
    }
}
