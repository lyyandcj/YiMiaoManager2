package com.yimiao100.sale.yimiaomanager.view.activity;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jpeng.jptabbar.BadgeDismissListener;
import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.OnTabSelectListener;
import com.jpeng.jptabbar.anno.NorIcons;
import com.jpeng.jptabbar.anno.SeleIcons;
import com.jpeng.jptabbar.anno.Titles;
import com.yimiao100.sale.yimiaomanager.R;
import com.yimiao100.sale.yimiaomanager.view.fragment.ExpertFragment;
import com.yimiao100.sale.yimiaomanager.view.fragment.HomeFragment;
import com.yimiao100.sale.yimiaomanager.view.fragment.HonorFragment;
import com.yimiao100.sale.yimiaomanager.view.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnTabSelectListener, BadgeDismissListener {
    @Titles
    private static final int[] mTitles = {R.string.tab1, R.string.tab2, R.string.tab3, R.string.tab4};

    @SeleIcons
    private static final int[] mSeleIcons = {R.mipmap.tab1_select, R.mipmap.tab2_select, R.mipmap.tab3_select, R.mipmap.tab4_select};

    @NorIcons
    private static final int[] mNormalIcons = {R.mipmap.tab1_normal, R.mipmap.tab2_normal, R.mipmap.tab3_normal, R.mipmap.tab4_normal};
    private ViewPager mPager;

    private JPTabBar mTabbar;
    private HomeFragment homeFragment;
    private HonorFragment honorFragment;
    private ExpertFragment expertFragment;
    private MineFragment mineFragment;
    private List<Fragment> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabbar = findViewById(R.id.tabbar);
        mPager = findViewById(R.id.view_pager);
        //百事通
        homeFragment = new HomeFragment();
        //荣誉榜
        honorFragment = new HonorFragment();
        //专家库
        expertFragment = new ExpertFragment();
        //我的
        mineFragment = new MineFragment();
        mTabbar.setGradientEnable(true);
        mTabbar.setPageAnimateEnable(true);
        mTabbar.setTabListener(this);
        list.add(homeFragment);
        list.add(honorFragment);
        list.add(expertFragment);
        list.add(mineFragment);
        mTabbar.setContainer(mPager);
        //设置Badge消失的代理
        mTabbar.setDismissListener(this);
        mTabbar.setTabListener(this);
        if (mTabbar.getMiddleView() != null)
            mTabbar.getMiddleView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
    }

    @Override
    public void onTabSelect(int index) {

    }

    @Override
    public boolean onInterruptSelect(int index) {
        return false;
    }

    @Override
    public void onDismiss(int position) {

    }
}
