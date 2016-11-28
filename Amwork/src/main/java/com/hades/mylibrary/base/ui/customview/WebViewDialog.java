package com.hades.mylibrary.base.ui.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.cloud.ui.views.ShareDialog;


public class WebViewDialog extends Dialog {

    private static String gtitle = null;
    private static String gurl = null;
    private static int gresid = 0;
    private static String gThumbPath = null;
    private WebView webview = null;
    Context context;
    ImageView btn;
    TextView sharedBt;
    TextView t;
    ImageView guide_iv;
    String mActionType;


    public interface OnCustomDialogListener {
        public void back(String name);
    }

    public WebViewDialog(Context context, String url, String title, int resid, String thumbPath, String action_type) {
        super(context, R.style.AppTheme);
        this.context = context;
        this.gurl = url;
        this.gtitle = title;
        this.gresid = resid;
        this.gThumbPath = thumbPath;
        this.mActionType = action_type;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void colseDialog() {
        WebViewDialog.this.dismiss();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    private class MyWebViewDownLoadListener implements DownloadListener {
        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,
                                    long contentLength) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }
    }

    String mytitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        webview = (WebView) findViewById(R.id.webview);
        sharedBt = (TextView) findViewById(R.id.shared_text);
        guide_iv = (ImageView) findViewById(R.id.guide_iv);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

//                Toast.makeText(context,"ll",Toast.LENGTH_SHORT).show();
                if (url.contains("action=close")) {
                    colseDialog();
                    return true;
                } else if (url.contains("action=share")) {
                    sharedBt.setVisibility(View.VISIBLE);
                    webview.loadUrl(url);
                    return false;
                }
                return true;
            }

        });

        sharedBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //actiontype = "" 不传
                if (gtitle.equals("我的积分")) {
                    ShareDialog dialog = new ShareDialog(context, "jifen", gurl, mytitle, mActionType);
                    Window window = dialog.getWindow();
                    window.setGravity(Gravity.BOTTOM);
                    dialog.setCanceledOnTouchOutside(true);// 设置点击Dialog外部任意区域关闭Dialog
                    dialog.show();
                }

//      app没法传          share.exchange	分享了积分兑换 action_target最好能传兑换的那个奖励的唯一标识码
                else if (gtitle.equals("积分兑换")) {
                    ShareDialog dialog = new ShareDialog(context, "duihuan", gurl, mytitle, mActionType);

                    Window window = dialog.getWindow();
                    window.setGravity(Gravity.BOTTOM);
                    dialog.setCanceledOnTouchOutside(true);// 设置点击Dialog外部任意区域关闭Dialog
                    dialog.show();
                }
                //actiontype = ""
                else if (gtitle.equals("学习档案")) {
                    ShareDialog dialog = new ShareDialog(context, "dangan", gurl, mytitle, mActionType);

                    Window window = dialog.getWindow();
                    window.setGravity(Gravity.BOTTOM);
                    dialog.setCanceledOnTouchOutside(true);// 设置点击Dialog外部任意区域关闭Dialog
                    dialog.show();
                }

            }
        });


        // webview.setWebViewClient(new webViewClient());

        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int newProgress) {
//                loadingIndicatorView.setVisibility(View.INVISIBLE);
            }
        });


        btn = (ImageView) findViewById(R.id.web_back);
        if (webview != null && gurl != null && gurl.length() > 0) {
            try {
                WebSettings webSettings = webview.getSettings();
                webSettings.setSavePassword(false);
                webSettings.setSaveFormData(false);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                webSettings.setSupportZoom(false);
                webSettings.setDomStorageEnabled(true);
                webview.clearSslPreferences();
                webview.setWebViewClient(new webViewClient());
                webview.setWebChromeClient(new MyWebChromeClient());
                webview.loadUrl(gurl);

            } catch (Throwable t) {
            }
        }

        webview.setDownloadListener(new MyWebViewDownLoadListener());


        if (gtitle != null) {
            t = (TextView) findViewById(R.id.title_text);
            t.setText(gtitle);
            //	imageview.setVisibility(View.INVISIBLE);
        }

        //返回键
        {
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    colseDialog();
                }
            });
        }
    }

    class webViewClient extends WebViewClient {
        //重写shouldOverrideUrlLoading方法，使点击链接后不使用其他的浏览器打开�?
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            WebView.HitTestResult hit = view.getHitTestResult();
            if (hit != null) {
                int hitType = hit.getType();
                if (hitType == WebView.HitTestResult.SRC_ANCHOR_TYPE) {//点击超链�?
                    //这里执行自定义的操

                    if (url.contains("action=close")) {
                        colseDialog();
                        view.loadUrl(url);
                    }
                    return true;//返回true浏览器不再执行默认的操作
                } else if (hitType == 0) {//重定向时hitType�?0
                    return false;//不捕�?302重定�?
                } else {
                    return false;
                }
            }
            return false;
        }
    }

    /**
     * Provides a hook for calling "alert" from javascript. Useful for
     * debugging your javascript.
     */
    final class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            Log.i("ANDROID_LAB", "TITLE=" + title);
            mytitle = title;
            //此处动态更新title
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();
            return true;
        }
    }

}
