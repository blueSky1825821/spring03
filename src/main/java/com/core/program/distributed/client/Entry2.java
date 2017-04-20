package com.core.program.distributed.client;

import com.core.program.distributed.stub.UserManagerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by sky on 2017/4/18.
 */
public class Entry2 {
    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2001);
            UserManagerInterface userManager = (UserManagerInterface) registry.lookup("userManager");
            System.out.println("" + userManager.getAdminAccount().getUsername()
                    + userManager.getAdminAccount().getPassword());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
