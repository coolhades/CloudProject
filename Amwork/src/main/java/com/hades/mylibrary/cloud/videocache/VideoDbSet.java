package com.hades.mylibrary.cloud.videocache;

import com.hades.mylibrary.base.data.DbController;
import com.hades.mylibrary.cloud.dbmodel.DownLoadInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hades on 2016/11/30.
 * 视频储存控制
 */
public class VideoDbSet {
    private static Map<String, DownLoadInfo> downloadInfoMap;
    public static void init() {
        downloadInfoMap = new HashMap<String, DownLoadInfo>();
        List<DownLoadInfo> loadInfos = DbController.liteOrm.query(DownLoadInfo.class);
        if (loadInfos.isEmpty()) return;
        for (int i = 0; i < loadInfos.size(); i++) {
            downloadInfoMap.put(loadInfos.get(i).getTitle(), loadInfos.get(i));
        }
    }

    /**
     * 创建时间 2016/11/30
     * auther Hades
     * 描述  save data when quit
     **/
    public static void saveData() {
        //清除当前数据 重新保存
        DbController.liteOrm.delete(DownLoadInfo.class);

        for (DownLoadInfo downloadInfo : downloadInfoMap.values()) {
            DbController.liteOrm.save(downloadInfo);
        }

    }

    public static List<DownLoadInfo> getDownloadInfos() {
        return new ArrayList<DownLoadInfo>(downloadInfoMap.values());
    }

    /**
     * 创建时间 2016/11/30
     * auther Hades
     * 描述
     **/
    public static boolean hasDownloadInfo(String Title) {
        return downloadInfoMap.containsKey(Title);
    }

    public static DownLoadInfo getDownloadInfo(String Title) {
        return downloadInfoMap.get(Title);
    }


    //全局下载信息储存
    public static void addDownloadInfo(DownLoadInfo downloadInfo) {
        synchronized (downloadInfoMap) {
            if (downloadInfoMap.containsKey(downloadInfo.getTitle())) {
                //任务已存在
                return;
            }
            downloadInfoMap.put(downloadInfo.getTitle(), downloadInfo);
            DbController.liteOrm.save(downloadInfo);
        }
    }

    public static void removeDownloadInfo(String title) {
        synchronized (downloadInfoMap) {
            downloadInfoMap.remove(title);
        }
    }

    public static void updateDownloadInfo(DownLoadInfo downloadInfo) {
        synchronized (downloadInfoMap) {
            downloadInfoMap.put(downloadInfo.getTitle(), downloadInfo);
        }

    }

}
