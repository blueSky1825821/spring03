package com.core.program.nio.test02;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * Created by sky on 2017/4/6.
 */
public interface TCPProtocol {
    //accept I/O形式
    void handleAccept(SelectionKey key) throws IOException;
    //read I/O形式
    void handleRead(SelectionKey key) throws IOException;
    //write I/O形式
    void handleWrite(SelectionKey key) throws IOException;
}
