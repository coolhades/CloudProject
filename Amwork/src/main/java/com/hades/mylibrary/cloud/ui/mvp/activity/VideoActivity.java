package com.hades.mylibrary.cloud.ui.mvp.activity;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bokecc.sdk.mobile.play.DWMediaPlayer;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.ScreenUtils;
import com.hades.mylibrary.base.ui.customview.IndicatorManager;
import com.hades.mylibrary.base.ui.mvp.activity.BaseActivity;
import com.hades.mylibrary.cloud.adapter.VideoViewPagerAdapter;
import com.hades.mylibrary.cloud.bean.VideoInfo;
import com.hades.mylibrary.cloud.constant.ConstantSet;
import com.hades.mylibrary.cloud.ui.mvp.fragment.VideoPageCourseListFragment;
import com.hades.mylibrary.cloud.ui.mvp.presenter.VideoPresenter;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;
import com.hades.mylibrary.cloud.utils.CCdrmServerManager;

import net.lucode.hackware.magicindicator.MagicIndicator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Hades on 2016/11/15.
 */

public class VideoActivity extends BaseActivity<VideoPresenter> implements ILoadData {

    ImageView back;
    TextView videoTitle;
    ImageView collectIv;
    MagicIndicator magicIndicator;
    ViewPager videoViewpager;
    VideoViewPagerAdapter pagerAdapter;

    LinearLayout header;//顶部栏

    protected int CurOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    List<Fragment> fragmentList;

    private static final String[] CHANNELS = new String[]{"目录", "简介", "提问", "学习"};
    private List<String> mDataList = Arrays.asList(CHANNELS);


    DWMediaPlayer player;
    SurfaceHolder surfaceHolder;
    SurfaceView playerSurfaceView;
    RelativeLayout rl_play;//播放区域布局，控制全屏
    ProgressBar bufferProgressBar;//视频加载缓冲


    LinearLayout video_bar;//底部栏 时间、进度
    LinearLayout title_bar;//title bar
    ImageView back_fullscreem;//退出全屏
    TextView video_name;//视频title
    ImageView start_bt;//播放暂停按钮
    TextView time1;//播放时间
    SeekBar number_progress_bar;//进度条
    TextView time2;//总时间
    ImageView expend_img;//全屏
    LinearLayout shared_bar;//分享
    ImageView reply_btn;//
    ImageView play_next;
    TextView timeTick;


    //
    Boolean isFullScreen = false;
    Boolean isBarShow = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_videoclass_ly);
        EventBus.getDefault().register(this);
        init(savedInstanceState);

    }

    @Override
    protected VideoPresenter onLoadPresenter() {
        return new VideoPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        videoViewpager = (ViewPager) findViewById(R.id.video_viewpager);
        magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator);
        back = (ImageView) findViewById(R.id.btn_back);
        collectIv = (ImageView) findViewById(R.id.btn_collect);
        videoTitle = (TextView) findViewById(R.id.video_title);
        header = (LinearLayout) findViewById(R.id.header);

        IndicatorManager.initMagicIndicator(this, magicIndicator, videoViewpager, mDataList);

        //加载viewpager的view
        fragmentList = new ArrayList<>();
        fragmentList.add(new VideoPageCourseListFragment());
        fragmentList.add(new VideoPageCourseListFragment());
        fragmentList.add(new VideoPageCourseListFragment());
        fragmentList.add(new VideoPageCourseListFragment());

        pagerAdapter = new VideoViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        videoViewpager.setAdapter(pagerAdapter);

        //player 部分
        playerSurfaceView = (SurfaceView) findViewById(R.id.playerSurfaceView);
        rl_play = (RelativeLayout) findViewById(R.id.rl_play);
        bufferProgressBar = (ProgressBar) findViewById(R.id.bufferProgressBar);
        back_fullscreem = (ImageView) findViewById(R.id.back_fullscreem);
        video_name = (TextView) findViewById(R.id.video_name_visible);
        start_bt = (ImageView) findViewById(R.id.start_bt);
        video_bar = (LinearLayout) findViewById(R.id.video_bar);
        title_bar = (LinearLayout) findViewById(R.id.title_bar);
        time1 = (TextView) findViewById(R.id.time1);
        number_progress_bar = (SeekBar) findViewById(R.id.number_progress_bar);
        time2 = (TextView) findViewById(R.id.time2);
        expend_img = (ImageView) findViewById(R.id.expend_img);
        shared_bar = (LinearLayout) findViewById(R.id.shared_bar);
        reply_btn = (ImageView) findViewById(R.id.reply_btn);
        play_next = (ImageView) findViewById(R.id.play_next);
        timeTick = (TextView) findViewById(R.id.btnGetCode);

        initViewHolder();
        playBarController(false);
    }


    /**
    * 创建时间 2016/11/18
    * auther Hades
    * 描述   surfaceview 背景图片
     *       Viewpager各个view的数据，也可以在view内部加载
    **/
    @Override
    public void onInitData(String data) {

    }

    /**
     * 创建时间 2016/11/18
     * auther Hades
     * 描述  播放指定视频
     *
     * @param store_value  视频地址[加密字符串]
     * @param store_config 是否加密视频
     * @param store_type   本地或线上视频
     **/
    @Subscribe(priority = 20)
    public void playVideo(VideoInfo info) {
//        reSetPlayer(store_value, store_type, store_config);
    }

    String path;
    /**
     * 创建时间 16/9/20
     * auther Hades
     * 描述  设置player资源 配置cc账号
     **/
    private void reSetPlayer(String store_value, String store_type, String store_config) {
        initPlayer();
        player.setDRMServerPort(CCdrmServerManager.getInstance().getDrmServerPort());
        try {

            if (store_type.equalsIgnoreCase("2")) {// 播放线上视频
                //此处进行加密 未加密判断
                if (store_config.equalsIgnoreCase("2")) {
                    //设置数据
                    player.setVideoPlayInfo(store_value, ConstantSet.CC_Account_id, ConstantSet.CC_Account_Key, this);
                } else if (store_config.equalsIgnoreCase("1")) {
                    player.setVideoPlayInfo(store_value, ConstantSet.CC_Account_NO_id, ConstantSet.CC_Account_NO_Key, this);
                }
                player.prepareAsync();//准备
            } else {// 播放本地已下载视频
                if (android.os.Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

//                    path = Environment.getExternalStorageDirectory() + "/".
//                            concat(ConfigUtil.DOWNLOAD_DIR).concat("/").concat(videoId).concat(MediaUtil.PCM_FILE_SUFFIX);
//
//                    if (!new File(path).exists()) {
//                        finish();
//                    }

                }
            }

        } catch (IllegalArgumentException e) {
            Log.e("player error", e.getMessage());
        } catch (SecurityException e) {
            Log.e("player error", e.getMessage());
        } catch (IllegalStateException e) {
            Log.e("player error", "illegal", e);
        }
    }


    @Override
    protected void initEvent() {
        rl_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBarShow) {
                    playBarController(false);
                    isBarShow = false;
                }else {
                    playBarController(true);
                    isBarShow = true;
                }
            }
        });

        start_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        expend_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeScreen();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoActivity.this.finish();
            }
        });
    }

    private void initViewHolder() {
        surfaceHolder = playerSurfaceView.getHolder();//SurfaceHolder是SurfaceView的控制接口
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                //初始化player
//                initPlayer();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.d("TAG-SurfaceHolder", "Destory");
            }
        });
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);//Surface类型
    }


    @Override
    protected void initData() {
        mPresenter.fetchData();


    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



    @Deprecated
    private void changeOrientation(boolean isLandscape) {
        if (isLandscape) {
            CurOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                    | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            header.setVisibility(View.GONE);
//            rlParent.setLayoutParams(lp);
        } else {
            CurOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            header.setVisibility(View.VISIBLE);

        }
    }

    private void initPlayer() {

        if (player != null) {
            player.release();
        }
        player = new DWMediaPlayer();
        player.reset();
        player.setDisplay(surfaceHolder);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setScreenOnWhilePlaying(true);
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //准备完毕 可以播放了
            }
        });

        //播放完成
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //重置信息,显示分享bar
            }
        });
        //进度拖放
        player.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            public void onSeekComplete(MediaPlayer m) {
                m.start();

            }
        });

        player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                start_bt.setImageResource(R.mipmap.btn_video_stopplay);
                return false;
            }
        });

        player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                number_progress_bar.setSecondaryProgress(percent);
            }
        });

        player.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    case DWMediaPlayer.MEDIA_INFO_BUFFERING_START:
                        if (player.isPlaying()) {
                            bufferProgressBar.setVisibility(View.VISIBLE);
                        }
                        break;
                    case DWMediaPlayer.MEDIA_INFO_BUFFERING_END:
                        bufferProgressBar.setVisibility(View.GONE);
                        break;
                }
                return false;
            }
        });
    }

    //进入全屏
    private void enterFullScreen() {
        expend_img.setImageResource(R.mipmap.btn_video_smallscreen);
        //显示返回按钮
        back_fullscreem.setVisibility(View.VISIBLE);
        isFullScreen = true;
        header.setVisibility(View.GONE);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().getDecorView().setSystemUiVisibility(View.INVISIBLE);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        rl_play.setLayoutParams(lp);
    }

    //退出全屏
    private void exitFullScreen() {
        isFullScreen = false;
        video_bar.setVisibility(View.VISIBLE);
        back_fullscreem.setVisibility(View.INVISIBLE);
        header.setVisibility(View.VISIBLE);
        expend_img.setImageResource(R.mipmap.btn_video_fullscreen);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ScreenUtils.getPhoneScreenWidth(this),
                (ScreenUtils.getPhoneScreenWidth(this) / 16)*9
        );
        rl_play.setLayoutParams(lp);

    }

    private void playBarController(Boolean show) {
        if (show) {
            video_bar.setVisibility(View.VISIBLE);
            title_bar.setVisibility(View.VISIBLE);
            start_bt.setVisibility(View.VISIBLE);
            video_name.setVisibility(View.VISIBLE);
        } else {
            video_bar.setVisibility(View.GONE);
            title_bar.setVisibility(View.GONE);
            start_bt.setVisibility(View.GONE);
        }
    }

    private void changeScreen() {
        if (isFullScreen) {
            //退出全屏
            exitFullScreen();
        } else {
            enterFullScreen();
        }
    }
}
