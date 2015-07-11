package com.paulusworld.drawernavigationtabs.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.paulusworld.drawernavigationtabs.MainActivity;
import com.paulusworld.drawernavigationtabs.MostLikedFragmentB;
import com.paulusworld.drawernavigationtabs.MostRecentFragmentB;
import com.paulusworld.drawernavigationtabs.UpcomingFragmentB;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabsPagerAdapterB extends FragmentStatePagerAdapter {

    public TabsPagerAdapterB(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        final String TAG = MainActivity.class.getSimpleName();


        Log.v(TAG, "tabs pager adapterB");
        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new MostRecentFragmentB();
            case 1:
                // Games fragment activity
                return new MostLikedFragmentB();
            case 2:
                // Movies fragment activity
                return new UpcomingFragmentB();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
