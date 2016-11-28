package com.hades.mylibrary.cloud.videocache;

import com.bokecc.sdk.mobile.download.Downloader;
import com.hades.mylibrary.cloud.utils.CCdrmServerManager;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Hades on 2016/11/28.
 * 平台相关，保存了全局下载信息
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
    public  HashMap<String, Downloader> downloaderHashMap = new HashMap<String, Downloader>();

    public void initDownloaderHashMap(){
        //初始化DownloaderHashMap
        List<DownloadInfo> downloadInfoList = DataSet.getDownloadInfos();
        for(int i = 0; i<downloadInfoList.size(); i++){
            DownloadInfo downloadInfo = downloadInfoList.get(i);
            if (downloadInfo.getStatus() == Downloader.FINISH) {
                continue;
            }
            String title = downloadInfo.getTitle();
            File file = MediaUtil.createFile(title, MediaUtil.PCM_FILE_SUFFIX);
            if (file == null ){
                continue;
            }

            String dataVideoId = downloadInfo.getVideoId();
            Downloader downloader = new Downloader(file, dataVideoId, CCdrmServerManager.getInstance().getCC_Account_id(), CCdrmServerManager.getInstance().getCC_Account_Key());

            int downloadInfoDefinition = downloadInfo.getDefinition();
            if (downloadInfoDefinition != -1){
                downloader.setDownloadDefinition(downloadInfoDefinition);
            }
            downloaderHashMap.put(title, downloader);
        }
    }

    public void addDownLoaderInfo(String videoId, String title, int definition ,Downloader downloader){
        downloaderHashMap.put(title, downloader);
        DataSet.addDownloadInfo(new DownloadInfo(videoId, title, 0, null, Downloader.WAIT, new Date(), definition));
    }


    public void addDownLoaderInfo(String videoId, String title, Downloader downloader){
        downloaderHashMap.put(title, downloader);
        DataSet.addDownloadInfo(new DownloadInfo(videoId, title, 0, null, Downloader.WAIT, new Date()));
    }

}
