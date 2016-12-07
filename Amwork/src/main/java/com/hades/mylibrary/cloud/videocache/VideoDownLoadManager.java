package com.hades.mylibrary.cloud.videocache;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.bokecc.sdk.mobile.download.Downloader;
import com.hades.mylibrary.cloud.utils.CCdrmServerManager;

import java.io.File;

/**
 * Created by Hades on 2016/11/30.
 * 下载管理类
 */
public class VideoDownLoadManager {
    private VideoDownLoadManager() {
    }

    private static class Instance{
        private static VideoDownLoadManager manager = new VideoDownLoadManager();
    }

    public static VideoDownLoadManager getInstance(){
        return Instance.manager;
    }

    public void startDownLoad(Context context,VideoDownLoadService.DownloadBinder binder, String title, String videoId, String videotype){
        if (VideoDbSet.hasDownloadInfo(title)) {
            Toast.makeText(context, "文件已存在", Toast.LENGTH_SHORT).show();
            return;
        }

        File file;
        if (videotype.equalsIgnoreCase("encrypt")) {
            file = MediaUtil.createFile(title, MediaUtil.PCM_FILE_SUFFIX);//加密
        }else {
            file = MediaUtil.createFile(title, MediaUtil.MP4_FILE_SUFFIX);
        }
        if (file == null ){
            Toast.makeText(context, "创建文件失败", Toast.LENGTH_LONG).show();
            return;
        }
        Downloader downloader;
        if (videotype.equalsIgnoreCase("encrypt")) {
            downloader = new Downloader(file, videoId, CCdrmServerManager.getInstance().getCC_Account_id(),
                    CCdrmServerManager.getInstance().getCC_Account_Key());
        }else {
            downloader = new Downloader(file, videoId, CCdrmServerManager.getInstance().getCC_Account_NO_id(),
                    CCdrmServerManager.getInstance().getCC_Account_NO_Key());
        }
        DownLoadInfoMap.getInstance().addDownLoaderInfo(videoId, videotype, videoId, downloader);

        if (binder == null || binder.isStop()) {
            Intent service = new Intent(context, VideoDownLoadService.class);
            service.putExtra("title", title);
            context.startService(service);
        } else{
            Intent intent = new Intent(ConfigUtil.ACTION_DOWNLOADING);
            context.sendBroadcast(intent);
        }
        Toast.makeText(context, "文件已加入下载队列", Toast.LENGTH_SHORT).show();
    }
}
