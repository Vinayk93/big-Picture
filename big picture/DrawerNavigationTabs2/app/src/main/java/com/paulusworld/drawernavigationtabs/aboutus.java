package com.paulusworld.drawernavigationtabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class aboutus extends Activity  {

    private SearchView mSearchView;
    private TextView mStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.main, menu);

        return true;
    }


}
