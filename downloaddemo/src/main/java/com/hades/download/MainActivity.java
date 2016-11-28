package com.hades.download;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import zlc.season.rxdownload.DownloadRecord;
import zlc.season.rxdownload.DownloadStatus;
import zlc.season.rxdownload.RxDownload;

public class MainActivity extends AppCompatActivity {

    private String url = "http://dldir1.qq.com/weixin/android/weixin6331android940.apk";
    ProgressBar progressbar;
    RxDownload rxDownlaod;//不是单例
    Subscription subScription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        findViewById(R.id.downlaod).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //控制下载
                startdownload();
            }
        });
        findViewById(R.id.pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pausedownlaod();
            }
        });

        rxDownlaod = RxDownload.getInstance().context(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 读取下载状态, 如果存在下载记录,则初始化为上次下载的状态
        Subscription query = rxDownlaod.getDownloadRecord(url)
                .subscribe(new Action1<DownloadRecord>() {
                    @Override
                    public void call(DownloadRecord record) {
                        //如果有下载记录才会执行到这里, 如果没有下载记录不会执行这里
                        progressbar.setIndeterminate(record.getStatus().isChunked);
                        progressbar.setMax((int) record.getStatus().getTotalSize());
                        progressbar.setProgress((int) record.getStatus().getDownloadSize());

                    }
                });
    }

    private void pausedownlaod() {
        if (subScription != null && !subScription.isUnsubscribed())
            subScription.unsubscribe();
    }

    private void startdownload() {
        subScription = rxDownlaod
                .download(url, "weixin.apk", null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DownloadStatus>() {
                    @Override
                    public void onCompleted() {
                        //下载完成
                        Log.d("TAG-DownLoad","完成下载");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //下载出错
                    }

                    @Override
                    public void onNext(final DownloadStatus status) {
                        //下载状态
                        Log.d("TAG-DownLoad","已下载"+status.getDownloadSize());
                        progressbar.setMax((int) status.getTotalSize());
                        progressbar.setProgress((int) status.getDownloadSize() );
                    }
                });
    }

}
