package com.paulusworld.drawernavigationtabs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.widget.Toast;

import com.paulusworld.drawernavigationtabs.MainActivity;
import com.paulusworld.drawernavigationtabs.MostLikedFragmentH;
import com.paulusworld.drawernavigationtabs.MostRecentFragmentH;
import com.paulusworld.drawernavigationtabs.UpcomingFragmentH;

public class TabsPagerAdapterH extends FragmentStatePagerAdapter {

	public TabsPagerAdapterH(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
        final String TAG = MainActivity.class.getSimpleName();

        Log.v(TAG, "tabs pager adapterh");
        switch (index) {
		case 0:
			// Top Rated fragment activity

			return new MostRecentFragmentH();
		case 1:
			// Games fragment activity
            return new MostLikedFragmentH();
		case 2:
			// Movies fragment activity
			return new UpcomingFragmentH();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
