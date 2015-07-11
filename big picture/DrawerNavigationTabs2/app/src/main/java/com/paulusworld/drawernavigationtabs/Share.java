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
public class Share extends Fragment {

    public final static String TAG = Rateus.class.getSimpleName();

    public Share() {
        // TODO Auto-generated constructor stub
    }

    public static  Share newInstance() {
        return new Share();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.share, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webView = (WebView) view.findViewById(R.id.webView);

        webView.loadUrl("http://m.bollywoodhungama.com/en/h5");
    }
}
