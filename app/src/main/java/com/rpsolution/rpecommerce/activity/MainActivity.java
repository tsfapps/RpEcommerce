package com.rpsolution.rpecommerce.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rpsolution.rpecommerce.R;
import com.rpsolution.rpecommerce.adapter.RvBannerAdapter;
import com.rpsolution.rpecommerce.adapter.RvCategoryAdapter;
import com.rpsolution.rpecommerce.adapter.RvSubBannerAdapter;
import com.rpsolution.rpecommerce.model.RvBannerModel;
import com.rpsolution.rpecommerce.model.RvCategoryModel;
import com.rpsolution.rpecommerce.model.RvSubBannerModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<RvBannerModel> rvBannerModels = new ArrayList<>();
    private List<RvSubBannerModel> rvSubBannerModels = new ArrayList<>();
    private List<RvCategoryModel> rvCategoryModels = new ArrayList<>();
    private RecyclerView.LayoutManager lmBanner;
    private RecyclerView.LayoutManager lmSubBanner;
    private RecyclerView.LayoutManager lmCategory;
    private RvBannerAdapter rvBannerAdapter;
    private RvSubBannerAdapter rvSubBannerAdapter;
    private RvCategoryAdapter rvCategoryAdapter;

    @BindView(R.id.rv_banner)
    protected RecyclerView rvBanner;
    @BindView(R.id.rv_subBanner)
    protected RecyclerView rvSubBanner;
    @BindView(R.id.rv_category)
    protected RecyclerView rvCategory;

    @BindView(R.id.drawer_layout)
    protected DrawerLayout mDrawer;
    @BindView(R.id.fab)
    protected FloatingActionButton fab;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.nav_view)
    protected NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initRvBanner();
        initRvSubBanner();
        initCategory();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initRvBanner(){
        lmBanner = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvBanner.setLayoutManager(lmBanner);
        rvBannerAdapter = new RvBannerAdapter(this, rvBannerModels);
        rvBanner.setAdapter(rvBannerAdapter);
        setBanner();

    }
    private void setBanner(){
        int[] banner = {R.drawable.banner_a, R.drawable.banner_b,R.drawable.banner_c, R.drawable.banner_d};
        for (int aBanner : banner) {
            RvBannerModel rvBannerModel = new RvBannerModel(aBanner);
            rvBannerModels.add(rvBannerModel);
        }
    }

    public void initRvSubBanner(){
        lmSubBanner = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvSubBanner.setLayoutManager(lmSubBanner);
        rvSubBannerAdapter = new RvSubBannerAdapter(this, rvSubBannerModels);
        rvSubBanner.setAdapter(rvSubBannerAdapter);
        setSubBanner();
    }

    public void setSubBanner(){
        int[] subBanner = {R.drawable.img_a, R.drawable.img_creals, R.drawable.img_daly, R.drawable.img_drinks, R.drawable.img_fruits, R.drawable.img_groceries, R.drawable.img_groceries_, R.drawable.img_creals, R.drawable.img_cart};
        for (int aSubBanner : subBanner) {
            RvSubBannerModel rvSubBannerModel = new RvSubBannerModel(aSubBanner);
            rvSubBannerModels.add(rvSubBannerModel);
        }
    }
    public void initCategory(){
        lmCategory = new GridLayoutManager(this, 3);
        rvCategory.setLayoutManager(lmCategory);
        rvCategoryAdapter = new RvCategoryAdapter(this, rvCategoryModels);
        rvCategory.setAdapter(rvCategoryAdapter);
        setCategory();
    }

    public void setCategory(){
        int[] catImg = {R.drawable.img_a, R.drawable.img_creals, R.drawable.img_daly, R.drawable.img_drinks, R.drawable.img_fruits, R.drawable.img_groceries, R.drawable.img_groceries_, R.drawable.img_creals, R.drawable.img_cart,R.drawable.img_daly, R.drawable.img_drinks, R.drawable.img_fruits};
        String[] catTitle = {"Daily Needs", "Rice","Daily Grocery","Drinks","Fruits","Weekly Grocery","Monthly Grocery","Cereals","Cart Delivery","Daily Grocery","Drinks","Fruits"};
        for (int i = 0; i<catImg.length; i++){
            RvCategoryModel rvCategoryModel = new RvCategoryModel(catImg[i], catTitle[i]);
            rvCategoryModels.add(rvCategoryModel);
        }
    }


    @Override
    public void onBackPressed() {

        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
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
        int id = item.getItemId();


        if (id == R.id.menu_cart) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_store) {

        } else if (id == R.id.nav_restaurant) {

        } else if (id == R.id.nav_coupon) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_rate) {

        }

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
