package com.hades.mylibrary.cloud.videocache;

import com.bokecc.sdk.mobile.download.Downloader;
import com.hades.mylibrary.cloud.dbmodel.DownLoadInfo;
import com.hades.mylibrary.cloud.utils.CCdrmServerManager;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Hades on 2016/11/28.
 * 课程列表页面 暂时没用
 */
public class DownLoadInfoMap {


    public static DownLoadInfoMap getInstance() {
        return Instance.instance;
    }

    private DownLoadInfoMap() {
    }

    private static class Instance {
        private static DownLoadInfoMap instance = new DownLoadInfoMap();
    }

    //定义hashmap存储downloader信息
    public HashMap<String, Downloader> downloaderHashMap = new HashMap<>();

    public void initDownloaderHashMap() {
        //初始化DownloaderHashMap
        List<DownLoadInfo> downloadInfoList = VideoDbSet.getDownloadInfos();
        for (int i = 0; i < downloadInfoList.size(); i++) {
            DownLoadInfo downloadInfo = downloadInfoList.get(i);
            if (downloadInfo.getStatus() == Downloader.FINISH) {
                continue;
            }
            String title = downloadInfo.getTitle();
            File file;
            //判断加密非加密
            if (downloadInfo.getVideotype().equalsIgnoreCase("encrypt")) {
                file = MediaUtil.createFile(title, MediaUtil.PCM_FILE_SUFFIX);//加密
            } else {
                file = MediaUtil.createFile(title, MediaUtil.MP4_FILE_SUFFIX);//非加密
            }
            if (file == null) {
                continue;
            }

            String dataVideoId = downloadInfo.getVideoId();
            Downloader downloader;
            //判断加密非加密
            if (downloadInfo.getVideotype().equalsIgnoreCase("encrypt")) {
                downloader = new Downloader(file, dataVideoId, CCdrmServerManager.getInstance().getCC_Account_id(),
                        CCdrmServerManager.getInstance().getCC_Account_Key());
            } else {
                downloader = new Downloader(file, dataVideoId, CCdrmServerManager.getInstance().getCC_Account_NO_id(),
                        CCdrmServerManager.getInstance().getCC_Account_NO_Key());
            }

            int downloadInfoDefinition = downloadInfo.getDefinition();
            if (downloadInfoDefinition != -1) {
                downloader.setDownloadDefinition(downloadInfoDefinition);
            }
            downloaderHashMap.put(title, downloader);
        }
    }

    public void addDownLoaderInfo(String videoId, String videotype, String title, int definition, Downloader downloader) {
        downloaderHashMap.put(title, downloader);
        VideoDbSet.addDownloadInfo(new DownLoadInfo(videoId, videotype, title, 0, null, Downloader.WAIT, new Date(), definition));
    }


    public void addDownLoaderInfo(String videoId, String videotype, String title, Downloader downloader) {
        downloaderHashMap.put(title, downloader);
        VideoDbSet.addDownloadInfo(new DownLoadInfo(videoId, videotype, title, 0, null, Downloader.WAIT, new Date()));
    }

}
