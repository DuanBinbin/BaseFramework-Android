package com.db.basic.utils;

import android.os.Build;

import java.io.Closeable;
import java.io.IOException;

/**
 * @描述：     @关闭相关工具类
 * @作者：     @蒋诗朋
 * @创建时间： @2017-04-25
 */
public final class CloseUtil {

    /**
     * 关闭IO
     *
     * @param closeables closeables
     */
    public static final void closeIO(final Closeable... closeables) {
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

    /**
     * 安全关闭流
     * @param closeable
     */
    public static final void closeQuietly(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    closeable.close();
                }
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * 安静关闭IO
     * @param closeables closeables
     */
    public static final void closeIOQuietly(final Closeable... closeables) throws IOException {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                closeable.close();
            }
        }
    }
}
