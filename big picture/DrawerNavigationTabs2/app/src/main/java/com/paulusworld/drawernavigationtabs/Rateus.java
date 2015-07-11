package com.paulusworld.drawernavigationtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

public class Rateus extends Fragment {

    public final static String TAG = Rateus.class.getSimpleName();

    public Rateus() {
        // TODO Auto-generated constructor stub
    }

    public static  Rateus newInstance() {
        return new  Rateus();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rateus, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webView = (WebView) view.findViewById(R.id.webView);
        try{
        webView.loadUrl("http://www.paulusworld.com");}
        catch (Exception ex){
            Toast.makeText(getActivity(),"Cannot load URL",Toast.LENGTH_LONG).show();
        }
    }
}
