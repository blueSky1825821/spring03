package com.core.program.distributed.server;

import com.core.program.distributed.UserManagerImpl;
import com.core.program.distributed.stub.UserManagerInterface;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by sky on 2017/4/18.
 * 分布式对象
 */
public class Entry {
    public static void main(String []args) throws AlreadyBoundException, RemoteException {
        UserManagerImpl userManager=new UserManagerImpl();
        UserManagerInterface userManagerI=(UserManagerInterface) UnicastRemoteObject.exportObject(userManager,0);
        // Bind the remote object's stub in the registry
        Registry registry = LocateRegistry.createRegistry(2001);
        registry.rebind("userManager", userManagerI);
        System.out.println("server is ready");
    }
}
