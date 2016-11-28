package com.hades.mylibrary.cloud.videocache;

import android.util.Log;

import com.bokecc.sdk.mobile.download.DownloadListener;
import com.bokecc.sdk.mobile.download.Downloader;
import com.bokecc.sdk.mobile.exception.DreamwinException;

import java.io.File;

/**
 * Created by Hades on 2016/11/23.
 */

public class VideoCacheManager {
    private Downloader downloader;//下载器
    File file;
    int progress;//进度
    private String progressText;//下载中信息
    private boolean stop = true;//停止下载


    public void startDownLoad(String videoId, String user_id, String api_key) {
        //file path由
        file = MediaUtil.createFile(videoId, MediaUtil.PCM_FILE_SUFFIX);
        if (file == null) {
            Log.i(MediaUtil.DOWNLAOD, "File is null");
            return;
        }
        downloader = new Downloader(file, videoId, user_id, api_key);
        downloader.setDownloadListener(downloadListener);
        downloader.start();
    }


    private DownloadListener downloadListener = new DownloadListener() {
        @SuppressWarnings("deprecation")
        @Override
        public void handleStatus(String videoId, int status) {
            switch (status) {
                case Downloader.PAUSE:

                    break;
                case Downloader.DOWNLOAD:

                    break;
                case Downloader.FINISH:
                    // 下载完毕 储存视频 id 和路径 path【持久化 并提供videoid、path 给VidePlayer 】

                    break;
            }
        }

        //start 开始 end 结束
        @Override
        public void handleProcess(long start, long end, String videoId) {
            if (stop) {
                //结束
                return;
            }
            //进度
            progress = (int) ((double) start / end * 100);
            if (progress <= 100) {
                progressText = ParamsUtil.byteToM(start).
                        concat(" M / ").
                        concat(ParamsUtil.byteToM(end).
                                concat(" M"));

            }
        }

        //出错了
        @Override
        public void handleException(DreamwinException exception, int status) {
            Log.i("Download exception", exception.getErrorCode().Value() + " : " );


        }

        //取消
        @Override
        public void handleCancel(String videoId) {
            Log.i(MediaUtil.DOWNLAOD, "cancel download, title: "  + ", videoId: " + videoId);

        }
    };
}
