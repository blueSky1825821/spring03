package com.core.program.distributed.stub;

import com.core.program.distributed.bean.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by sky on 2017/4/18.
 */
public interface UserManagerInterface extends Remote {
    public String getUserName() throws RemoteException;
    public Account getAdminAccount() throws RemoteException;
}
