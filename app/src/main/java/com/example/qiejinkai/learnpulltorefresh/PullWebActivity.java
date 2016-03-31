package com.example.qiejinkai.learnpulltorefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.handmark.pulltorefresh.library.PullToRefreshWebView;

public class PullWebActivity extends AppCompatActivity {

    PullToRefreshWebView mPullRefreshWebView;
    WebView mWebView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptr_webview);

        mPullRefreshWebView = (PullToRefreshWebView) findViewById(R.id.pull_refresh_webview);
        mWebView = mPullRefreshWebView.getRefreshableView();

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new SampleWebViewClient());
        mWebView.loadUrl("http://fund.xiaogutou.cn/");

    }

    private static class SampleWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
