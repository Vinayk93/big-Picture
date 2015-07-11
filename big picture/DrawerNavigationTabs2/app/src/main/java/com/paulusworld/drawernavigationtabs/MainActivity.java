package com.paulusworld.drawernavigationtabs;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.paulusworld.drawernavigationtabs.adapter.TabsPagerAdapterB;
import com.paulusworld.drawernavigationtabs.adapter.TabsPagerAdapterH;
import com.paulusworld.drawernavigationtabs.adapter.TabsPagerAdapterT;

import java.util.List;
import java.util.Objects;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	private static final String TAG = MainActivity.class.getSimpleName();
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mDrawerItmes;

    private ViewPager viewPager;
    private TabsPagerAdapterH mAdapter1;
    private TabsPagerAdapterB mAdapter2;
    private TabsPagerAdapterT mAdapter3;

    private SearchView mSearchView;
    private TextView mStatusView;

    private ActionBar actionBar;
    // Tab titles
    public String[] tabs1 = { "Most Recent", "Most Liked", "Upcoming" };
    public String[] tabs2 = { "Most Recent", "Most Liked", "Upcoming" };
    public String[] tabs3 = { "Most Recent", "Most Liked", "Upcoming" };



    @Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTitle = mDrawerTitle = getTitle();
		mDrawerItmes = getResources().getStringArray(R.array.drawer_titles);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		// set a custom shadow that overlays the main content when the drawer oepns
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,  GravityCompat.START);
		// Add items to the ListView
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerItmes));
		// Set the OnItemClickListener so something happens when a 
		// user clicks on an item.
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		// Enable ActionBar app icon to behave as action to toggle nav drawer

        getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);


		mDrawerToggle = new ActionBarDrawerToggle(
				this, 
				mDrawerLayout,
				R.drawable.ic_drawer, 
				R.string.drawer_open, 
				R.string.drawer_close
				) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);

                invalidateOptionsMenu();
				 // creates call to onPrepareOptionsMenu
			}
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu();
				// creates call to onPrepareOptionsMenu
			}
            public boolean onPrepareOptionsMenu(Menu menu) {
                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                boolean actionsVisibility = !drawerLayout.isDrawerVisible(Gravity.START);

                for(int i=0;i<menu.size();i++){
                    menu.getItem(i).setVisible(actionsVisibility);
                }
                return onPrepareOptionsMenu(menu);
            }
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		// Set the default content area to item 0
		// when the app opens for the first time
		if(savedInstanceState == null) {
			navigateTo(0);
		}
    }

    @Override
    protected void onResume() {
            navigateTo(0);
        super.onResume();
    }

    /*
         * If you do not have any menus, you still need this function
         * in order to open or close the NavigationDrawer when the user
         * clicking the ActionBar app icon.
         */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {



            }
        switch (item.getItemId()) {
            case R.id.action_settings:
                 Intent i = new Intent(MainActivity.this, settings.class);

                 startActivity(i);

                return true;

            case R.id.contactus:
                Intent i1 = new Intent(MainActivity.this, contactus.class);

                startActivity(i1);
                return true;


            case R.id.about:
                Intent i2 = new Intent(MainActivity.this, aboutus.class);

                startActivity(i2);
                return true;

        } return super.onOptionsItemSelected(item);
        //super.onOptionsItemSelected(item);






    }

	/*
	 * When using the ActionBarDrawerToggle, you must call it during onPostCreate()
	 * and onConfigurationChanged()
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

private class DrawerItemClickListener implements OnItemClickListener {
		@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Log.v(TAG, "ponies");
			navigateTo(position);
		}
	}
	private void navigateTo(final int position) {
		Log.v(TAG, "List View Item: " + position);

        android.support.v4.app.FragmentTransaction ft= getSupportFragmentManager()
                .beginTransaction();
        try {
            FrameLayout f1=(FrameLayout)findViewById(R.id.content_frame);
            f1.removeAllViews();
           viewPager.setAdapter(mAdapter1);
            actionBar.removeAllTabs();
            viewPager.setAdapter(null);
            viewPager.removeAllViews();
            mAdapter1.notifyDataSetChanged();
            mAdapter2.notifyDataSetChanged();
            mAdapter3.notifyDataSetChanged();
            viewPager.destroyDrawingCache();
            viewPager.removeAllViews();
            mAdapter2=null;
           mAdapter1=null;
           mAdapter3=null;

        onCreate(Bundle.EMPTY);
        }catch (Exception e){

}

		switch(position) {

		case 3:
setTitle("Tollywood");
            mDrawerLayout.closeDrawers();
            // Initilization
            viewPager = (ViewPager) findViewById(R.id.pager);
            actionBar = getActionBar();
            //remove previous one

            mAdapter1 = new TabsPagerAdapterH(getSupportFragmentManager());
            viewPager.setAdapter(mAdapter1);
            Log.v(TAG, "case hollywood");
            actionBar.setHomeButtonEnabled(true);
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            // Adding Tabs
            for (String tab_name : tabs1) {
                actionBar.addTab(actionBar.newTab().setText(tab_name)
                        .setTabListener(this));
            }

            /**
             * on swiping the viewpager make respective tab selected
             * */
            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageSelected(int position) {
                    // on changing the page
                    // make respected tab selected
                    actionBar.setSelectedNavigationItem(position);
                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {
                }

                @Override
                public void onPageScrollStateChanged(int arg0) {
                }
public int getItemPosition(Object object){
    return position;

}
            });
   break;

	case 1:setTitle("Hollywood");
            mDrawerLayout.closeDrawers();
            // Initilization
            viewPager = (ViewPager) findViewById(R.id.pager);
            actionBar = getActionBar();
            //remove all tabs

            mAdapter2 = new TabsPagerAdapterB(getSupportFragmentManager());
            viewPager.setAdapter(mAdapter2);
            Log.v(TAG, "case: bollywood");
            actionBar.setHomeButtonEnabled(true);
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            // Adding Tabs
            for (String tab_name : tabs2) {
                actionBar.addTab(actionBar.newTab().setText(tab_name)
                        .setTabListener(this));
                }
/**
             * on swiping the viewpager make respective tab selected
             * */
            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageSelected(int position) {
                    // on changing the page
                    // make respected tab selected
                    actionBar.setSelectedNavigationItem(position);
                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {
                }

                @Override
                public void onPageScrollStateChanged(int arg0) {
                }
            });
break;

         case 2:setTitle("Bollywood");
                    ft.commit();

                 mDrawerLayout.closeDrawers();
              // Initilization
                viewPager = (ViewPager) findViewById(R.id.pager);
                actionBar = getActionBar();
               mAdapter3 = new TabsPagerAdapterT(getSupportFragmentManager());
                 viewPager.setAdapter(mAdapter3);
                Log.v(TAG, "case: tollywood");
                // Adding Tabs

                for (String tab_name : tabs3) {
                    actionBar.addTab(actionBar.newTab().setText(tab_name)
                            .setTabListener(this));
                }
                /**
                 * on swiping the viewpager make respective tab selected
                 * */
                viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // on changing the page
                        // make respected tab selected
                        actionBar.setSelectedNavigationItem(position);
                    }
                    @Override
                    public void onPageScrolled(int arg0, float arg1, int arg2) {
                    }
                    @Override
                    public void onPageScrollStateChanged(int arg0) {
                    }
                });
             break;


            case 0:
                setTitle("BigPicture");
                mDrawerLayout.closeDrawers();

                ft.add(R.id.content_frame, home.newInstance()).commit();
                break;
            case 4:
                mDrawerLayout.closeDrawers();
setTitle("News");
                ft.add(R.id.content_frame, News.newInstance()).commit();
                break;
            case 6:
                mDrawerLayout.closeDrawers();
setTitle("Rate us");
                ft.add(R.id.content_frame, Rateus.newInstance()).commit();

                break;
            case 5:
                mDrawerLayout.closeDrawers();
setTitle("share");
                ft.add(R.id.content_frame, Share.newInstance()).commit();
                break;

            default : ft.add(R.id.content_frame,home.newInstance()).commit();
                setTitle("home");
        }
        }
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        return super.onCreateOptionsMenu(menu);
    }


}




