package com.service.axis;


import javax.xml.namespace.QName;
import java.rmi.RemoteException;

/**
 * Created by sky on 2016/11/22.
 */
public class ClientJWS {
    public static void main(String[] args) {
        String url = "http://localhost:8080/axis2/HelloWorldJWS.jws";
/*        Service service = new Service();
        try {
            Call call = service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName(url, "test"));
            String result = (String) call.invoke(new Object[]{"Rocky", 100});
            System.out.println("result = " + result);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/
    }
}
