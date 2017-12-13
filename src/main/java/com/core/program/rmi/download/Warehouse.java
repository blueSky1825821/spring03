package com.core.program.rmi.download;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by wm on 17-11-30.
 */
public interface Warehouse extends Remote{
    /**
     * 需要捕获 RemoteException 对远程调用进行异常处理
     * @param description
     * @return
     * @throws RemoteException
     */
    double getPrice(String description) throws RemoteException;
}
