package com.hades.mylibrary.base.projectutils;

import android.content.Context;

import java.io.InputStream;

/**
 * Created by Hades on 2016/11/2.
 */

public class GetSettingFile {

    public GetSettingFile getInstance(){
        return new SignalInstance().instance;
    }

    private GetSettingFile() {
    }

    private class SignalInstance{
        private  GetSettingFile instance = new GetSettingFile();
    }

    public String getFromAssets(String fileName, Context context) {
        String result = "";
        try {
            InputStream in = context.getResources().getAssets().open(fileName);
            //获取文件的字节数
            int lenght = in.available();
            //创建byte数组
            byte[] buffer = new byte[lenght];
            //将文件中的数据读到byte数组中
            in.read(buffer);
            result = new String(buffer, "UTF-8");
//                    .getString(buffer, "UTF-8");//你的文件的编码
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
