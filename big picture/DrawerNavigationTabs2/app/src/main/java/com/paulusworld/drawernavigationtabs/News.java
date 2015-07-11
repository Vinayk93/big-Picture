package com.paulusworld.drawernavigationtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by vinay on 19/3/15.
 */
public class News extends Fragment {

    public final static String TAG = Rateus.class.getSimpleName();

    public News() {
        // TODO Auto-generated constructor stub
    }

    public static  News newInstance() {
        return new News();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webView = (WebView) view.findViewById(R.id.webView);
        webView.loadUrl("http://m.koimoi.com");


    }
}

