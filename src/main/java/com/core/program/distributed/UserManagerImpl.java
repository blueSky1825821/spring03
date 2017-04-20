package com.core.program.distributed;

import com.core.program.distributed.bean.Account;
import com.core.program.distributed.stub.UserManagerInterface;

import java.rmi.RemoteException;

/**
 * Created by sky on 2017/4/18.
 */
public class UserManagerImpl implements UserManagerInterface {

    public UserManagerImpl() throws RemoteException {
        //super();
        // TODO Auto-generated constructor stub
        //UnicastRemoteObject.exportObject(this);
    }

    private static final long serialVersionUID = -3111492742628447261L;

    public String getUserName() throws RemoteException {
        // TODO Auto-generated method stub
        return "Tommy Lee";
    }

    public Account getAdminAccount() throws RemoteException {
        // TODO Auto-generated method stub
        Account account=new Account();
        account.setUsername("admin");
        account.setPassword("admin");
        return account;
    }
}
