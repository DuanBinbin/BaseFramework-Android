package com.db.basic.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @描述：     @Assets文件夹操作相关类
 * @作者：     @Bin
 * @创建时间： @2018/6/27 12:28
 */
public final class AssetsUtils {
    private static final String TAG = AssetsUtils.class.getSimpleName();
    /**
     * 将assets文件夹下的文件拷贝到/data/data/下
     *
     * @param context
     * @param fileName
     */
    public static String copyAssetsFile(Context context, String fileName) {
        Log.i(TAG, "copyAssetsFile: file name = " + fileName);
        InputStream in = null;
        FileOutputStream out = null;
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "com.zx.saveimgtogallery" + "/files/";
        String ret = null;
        File file = new File(path + fileName);
        ret = file.getPath();

        //创建文件夹
        File filePath = new File(path);
        if (!filePath.exists())
            filePath.mkdirs();

        if (file.exists())
            return ret;

        try {
            in = context.getAssets().open(fileName); // 从assets目录下复制
            out = new FileOutputStream(file);
            int length = -1;
            byte[] buf = new byte[1024];
            while ((length = in.read(buf)) != -1) {
                out.write(buf, 0, length);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return ret;
    }
}
