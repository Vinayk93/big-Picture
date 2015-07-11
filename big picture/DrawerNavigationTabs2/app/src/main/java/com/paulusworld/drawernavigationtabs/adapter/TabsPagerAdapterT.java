package com.paulusworld.drawernavigationtabs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.paulusworld.drawernavigationtabs.MainActivity;
import com.paulusworld.drawernavigationtabs.MostLikedFragmentH;
import com.paulusworld.drawernavigationtabs.MostLikedFragmentT;
import com.paulusworld.drawernavigationtabs.MostRecentFragmentH;
import com.paulusworld.drawernavigationtabs.MostRecentFragmentT;
import com.paulusworld.drawernavigationtabs.UpcomingFragmentH;
import com.paulusworld.drawernavigationtabs.UpcomingFragmentT;

public class TabsPagerAdapterT extends FragmentStatePagerAdapter {

    public TabsPagerAdapterT(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        final String TAG = MainActivity.class.getSimpleName();

        Log.v(TAG, "tabs pager adaptert");
        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new MostRecentFragmentT();
            case 1:
                // Games fragment activity
                return new MostLikedFragmentT();
            case 2:
                // Movies fragment activity
                return new UpcomingFragmentT();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
