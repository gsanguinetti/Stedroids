package com.stedroids.framework.ui.blocks;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.stedroids.framework.R;

/**
 * Created by gastonsanguinetti on 20/07/16.
 */
public abstract class AbstractNavigationActivity extends AbstractFragmentDrivenActivity
        implements DrawerLayout.DrawerListener {

    LinearLayout mainContainer;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    AppBarLayout appBarLayout;

    @Override
    protected int getContentRes() {
        return R.layout.activity_navigation_view;
    }

    @Override
    protected void onAfterSetContentView(Bundle savedInstanceState) {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mainContainer = (LinearLayout) findViewById(R.id.main_container);

        appBarLayout = getAppBarLayout();
        mainContainer.addView(appBarLayout);
        mainContainer.addView(getLayoutInflater().inflate(R.layout.activity_fragment_driven, mainContainer, false));

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, getToolbar(appBarLayout),
                getOpenDrawerStringResId(), getClosedDrawerStringResId());
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.addDrawerListener(this);

        navigationView.addHeaderView(getNavigationHeader());

        buildNavigationMenu(navigationView.getMenu());

        //Hacky for bug
        //TODO: Remove when not necessary
        MenuItem menuItem = navigationView.getMenu().getItem(navigationView.getMenu().size() - 1);
        menuItem.setTitle(menuItem.getTitle());
        ///////////////

        super.onAfterSetContentView(savedInstanceState);

    }

    public abstract Toolbar getToolbar(AppBarLayout appBarLayout);
    public abstract int getOpenDrawerStringResId();
    public abstract int getClosedDrawerStringResId();
    public abstract AppBarLayout getAppBarLayout();
    public abstract View getNavigationHeader();
    public abstract void buildNavigationMenu(Menu menu);
}
