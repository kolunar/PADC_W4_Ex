package com.padc.aml.w4_ex.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.padc.aml.w4_ex.R;
import com.padc.aml.w4_ex.W4ExApp;
import com.padc.aml.w4_ex.data.vos.JobVO;
import com.padc.aml.w4_ex.data.vos.MovieVO;
import com.padc.aml.w4_ex.fragments.JobSearchFragment;
import com.padc.aml.w4_ex.fragments.LinkedInFragment;
import com.padc.aml.w4_ex.fragments.MovieFragment;
import com.padc.aml.w4_ex.fragments.PulseFragment;
import com.padc.aml.w4_ex.fragments.WunZinnFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        JobSearchFragment.ControllerJobItem,
        LinkedInFragment.ControllerView,
        MovieFragment.ControllerMovieItem,
        PulseFragment.ControllerView,
        WunZinnFragment.ControllerView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            navigateToLinkedIn(0);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void navigateToLinkedIn(int index) {
        LinkedInFragment fragment = LinkedInFragment.newInstance(index);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }

    private void navigateToJobSearch(int index) {
        JobSearchFragment fragment = JobSearchFragment.newInstance(index);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }

    private void navigateToPulse(int index) {
        PulseFragment fragment = PulseFragment.newInstance(index);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }

    private void navigateToMovie(int index) {
        MovieFragment fragment = MovieFragment.newInstance(index);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }

    private void navigateToWunZinn(int index) {
        WunZinnFragment fragment = WunZinnFragment.newInstance(index);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        // Handle navigation view item clicks here.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (item.getItemId()) {
                    case R.id.nav_linked_in:
                        navigateToLinkedIn(0);
                        break;
                    case R.id.nav_job_search:
                        navigateToJobSearch(0);
                        break;
                    case R.id.nav_pulse:
                        navigateToPulse(0);
                        break;
                    case R.id.nav_movie:
                        navigateToMovie(0);
                        break;
                    case R.id.nav_wunzinn:
                        navigateToWunZinn(0);
                        break;
                }
            }
        }, 100); //to close drawer smoothly.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
    Activity - Fragment
                    |
                RecyclerView - Adapter
                                    |
                                ViewHolder
    */

    @Override
    public void onTapEvent(JobVO job) {
        Toast.makeText(W4ExApp.getContext(), "onTapEvent - JobVO", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTapEvent(MovieVO movie) {
        Toast.makeText(W4ExApp.getContext(), "onTapEvent - MovieVO", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentChange() {
        Toast.makeText(W4ExApp.getContext(), "onFragmentChange", Toast.LENGTH_LONG).show();
    }
}
