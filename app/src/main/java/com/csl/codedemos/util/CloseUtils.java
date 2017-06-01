package com.csl.codedemos.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * colose Closeable util
 */
public final class CloseUtils {

    private CloseUtils() {
    }

    public static void closeIO(Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
