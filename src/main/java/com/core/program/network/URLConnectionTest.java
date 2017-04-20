package com.core.program.network;

import org.jetbrains.annotations.NotNull;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by sky on 2017/4/11.
 */
public class URLConnectionTest {
    public static void main(String[] args) {

    }

}

class Base64OutputStream extends FilterOutputStream {
    private int col = 0;
    private int i = 0;
    private int[] inbuf = new int[3];

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field <tt>this.out</tt> for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public Base64OutputStream(@NotNull OutputStream out) {
        super(out);
    }

    public void write(int c) throws IOException{

    }
}
