package com.example.sion10032.hmsystem;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private NavigationView mNavigationView;
    private BottomNavigationView mBottomNavigationView;
    private HomePageFragment mHomepageFragment;
    private AssistantPageFragment mAssistantPageFragment;
    private EMedBoxPageFragment mEMedBoxPageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Replace Actionbar with Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Get views
        mNavigationView = findViewById(R.id.nav_view);
        mBottomNavigationView = findViewById(R.id.docky);

        // Initialize the listener
        initListener();

        // Set default page and checked item
        setPage(R.string.home_page);
        mBottomNavigationView.setSelectedItemId(R.id.navigation_homepage);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notification) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initListener(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_sports) {
                    // Handle the camera action
                } else if (id == R.id.nav_punch) {

                } else if (id == R.id.nav_preferences) {

                } else if (id == R.id.nav_settings) {

                } else if (id == R.id.nav_help) {

                } else if (id == R.id.nav_feedback) {

                }

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                int id = menuItem.getItemId();
                if(id == R.id.navigation_assistantpage){
                    setPage(R.string.assistant_page);
                }
                else if(id == R.id.navigation_homepage){
                    setPage(R.string.home_page);
                }
                else if(id == R.id.navigation_emedboxpage){
                    setPage(R.string.emedbox_page);
                }
                return true;
            }
        });
    }

    public void setPage(int pageId) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        if (pageId == R.string.home_page) {
            if (mHomepageFragment == null)
                mHomepageFragment = new HomePageFragment();
            transaction.replace(R.id.ContentWrapper, mHomepageFragment).commit();
        } else if (pageId == R.string.assistant_page) {
            if (mAssistantPageFragment == null)
                mAssistantPageFragment = new AssistantPageFragment();
            transaction.replace(R.id.ContentWrapper, mAssistantPageFragment).commit();
        } else if (pageId == R.string.emedbox_page) {
            if (mEMedBoxPageFragment == null)
                mEMedBoxPageFragment = new EMedBoxPageFragment();
            transaction.replace(R.id.ContentWrapper, mEMedBoxPageFragment).commit();

        }
    }
}
