package com.hymane.materialhome.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hymane.materialhome.R;
import com.hymane.materialhome.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import libcoll.libcollections.LibCollDB;


public class HomeFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    private List<BaseFragment> fragments;
    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData(boolean isSavedNull) {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        ((MainActivity) getActivity()).setToolbar(mToolbar);
        ((MainActivity) getActivity()).setFab(mFab);
    }

    private void init() {//拿到一个array，动态添加
        fragments = new ArrayList<>();
        fragments.add(CategoryFragment.newInstance());//分类
        fragments.add(DiscoverFragment.newInstance(0));//发现搜索

        LibCollDB.itfc.addCategory("首页");
        LibCollDB.itfc.addCategory("科技");
        LibCollDB.itfc.addCategory("散文");
        LibCollDB.itfc.addCategory("Category1");
        LibCollDB.itfc.addCategory("Category2");

        ArrayList<String> categories = LibCollDB.itfc.getCategories();
        for (String category : categories) {
            fragments.add(BookListFragment.newInstance(category));
        }

        mViewPager.setAdapter(new MainAdapter(getChildFragmentManager(), fragments, categories));
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setCurrentItem(2);  //默认打开首页
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(getContext().getResources().getColor(R.color.white));
    }

    private void change(ArrayList<String> newArray){
        mTabLayout.clearOnTabSelectedListeners();
        fragments = new ArrayList<>();
        fragments.add(CategoryFragment.newInstance());//分类
        fragments.add(DiscoverFragment.newInstance(0));//发现搜索
        int siz=newArray.size();
        for(int i=0;i<siz;i++){
            fragments.add(BookListFragment.newInstance(newArray.get(i)));
        }
        mViewPager.setAdapter(new MainAdapter(getChildFragmentManager(), fragments, newArray));
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setCurrentItem(2);  //默认打开首页
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(getContext().getResources().getColor(R.color.white));
    }

    class MainAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;
        private String[] titles;

        public MainAdapter(FragmentManager fm, List<BaseFragment> fragments,ArrayList<String> Cate_list) {
            super(fm);
            titles=new String[Cate_list.size()+2];
            titles[0]="分类";
            titles[1]="搜索";
            for(int i = 0; i < Cate_list.size();++i){
                titles[i+ 2]= Cate_list.get(i);
            }
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
