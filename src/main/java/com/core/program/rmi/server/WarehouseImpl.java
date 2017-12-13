package com.core.program.rmi.server;

import com.core.program.rmi.download.Warehouse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * UnicastRemoteObject 用于远程访问
 * Created by wm on 17-11-30.
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

    private Map<String, Double> prices;

    public WarehouseImpl() throws RemoteException {
        prices = new HashMap<>();
        prices.put("Blackwell Toaster", 24.95);
        prices.put("ZapXpress Microwave Oven", 49.95);
//        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public double getPrice(String description) throws RemoteException {
        Double price = prices.get(description);
        return price == null ? 0 : price;
    }
}
