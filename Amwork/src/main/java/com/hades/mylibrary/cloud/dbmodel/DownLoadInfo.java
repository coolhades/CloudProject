package com.hades.mylibrary.cloud.dbmodel;

import com.bokecc.sdk.mobile.download.Downloader;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;
import com.litesuits.orm.db.enums.AssignType;

import java.util.Date;

/**
 * Created by Hades on 2016/11/29.
 * String uid;
 * String nickname;
 * String avatar;
 * "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
 * "videoId VERCHAR, " +
 * "title VERCHAR, " +
 * "progress INTEGER, " +
 * "progressText VERCHAR, " +
 * "status INTEGER, " +
 * "createTime DATETIME, " +
 * "definition INTEGER)";
 */
@Table("downloadinfo_model")
public class DownLoadInfo {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    @Unique
    @NotNull
    private String videoId;
    @NotNull
    private String videotype;
    @NotNull
    private String title;
    @NotNull
    private int progress;

    private String progressText;
    @NotNull
    private int status;

    private Date createTime;
    private int definition;

    public DownLoadInfo(String videoId, String videotype,String title, int progress, String progressText, int status, Date createTime) {
        this.videoId = videoId;
        this.videotype = videotype;
        this.title = title;
        this.progress = progress;
        this.progressText = progressText;
        this.status = status;
        this.createTime = createTime;
        this.definition = -1;
    }

    public DownLoadInfo(String videoId, String videotype,String title, int progress, String progressText, int status, Date createTime, int definition) {
        this(videoId, videotype, title, progress, progressText, status, createTime);
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDefinition() {
        return definition;
    }

    public void setDefinition(int definition) {
        this.definition = definition;
    }

    public String getVideotype() {
        return videotype;
    }

    public void setVideotype(String videotype) {
        this.videotype = videotype;
    }

    public String getProgressText() {
        if (progressText == null) {
            progressText = "0M / 0M";
        }
        return progressText;
    }

    public void setProgressText(String progressText) {
        this.progressText = progressText;
    }

    public String getStatusInfo(){
        String statusInfo = "";
        switch (status) {
            case Downloader.WAIT:
                statusInfo = "等待中";
                break;
            case Downloader.DOWNLOAD:
                statusInfo = "下载中";
                break;
            case Downloader.PAUSE:
                statusInfo = "暂停中";
                break;
            case Downloader.FINISH:
                statusInfo = "已下载";
                break;
            default:
                statusInfo = "下载失败";
                break;
        }

        return statusInfo;
    }
}
