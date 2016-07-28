package com.github.star.floatingactionbuttonswitch;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.listener.OnRapidFloatingButtonGroupListener;
import com.wangjie.rapidfloatingactionbutton.rfabgroup.RapidFloatingActionButtonGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnRapidFloatingButtonGroupListener {

    private static final String TAG = "MainActivity";
    @Bind(R.id.rfab_group_sample_pts)
    PagerTabStrip mRfabGroupSamplePts;
    @Bind(R.id.rfab_group_sample_vp)
    ViewPager mRfabGroupSampleVp;
    @Bind(R.id.rfab_group_sample_rfab_a)
    RapidFloatingActionButton mRfabGroupSampleRfabA;
    @Bind(R.id.rfab_group_sample_rfab_b)
    RapidFloatingActionButton mRfabGroupSampleRfabB;
    @Bind(R.id.rfab_group_sample_rfab_c)
    RapidFloatingActionButton mRfabGroupSampleRfabC;
    @Bind(R.id.rfab_group_sample_rfabg)
    RapidFloatingActionButtonGroup mRfabGroupSampleRfabg;
    private List<BaseFragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rfab_group_sample);
        ButterKnife.bind(this);

        mRfabGroupSampleRfabg.setOnRapidFloatingButtonGroupListener(this);

        mRfabGroupSamplePts.setTabIndicatorColor(Color.RED);
        mRfabGroupSamplePts.setTextColor(0xff3f51b5);

        fragments.add(new FragmentA());
        fragments.add(new FragmentB());
        fragments.add(new FragmentC());

        mRfabGroupSampleVp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));

        mRfabGroupSampleVp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.e(TAG, "position == " + position);
                mRfabGroupSampleRfabg.setSection(position);
            }
        });
        mRfabGroupSampleVp.setOffscreenPageLimit(3);

    }

    @Override
    public void onRFABGPrepared(RapidFloatingActionButtonGroup rapidFloatingActionButtonGroup) {

        for (BaseFragment fragment : fragments) {
            fragment.onInitialRFAB(rapidFloatingActionButtonGroup.getRFABByIdentificationCode(fragment.getRfabIdentificationCode()));
        }
    }


    class MyPageAdapter extends FragmentStatePagerAdapter {

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments.get(position).getTitle();
        }
    }

}
