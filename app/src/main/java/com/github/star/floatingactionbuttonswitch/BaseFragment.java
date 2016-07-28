package com.github.star.floatingactionbuttonswitch;

import android.support.v4.app.Fragment;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;

/**
 * Created by xiongxingxing on 16/7/28.
 */

public abstract class BaseFragment extends Fragment {

    public abstract String getRfabIdentificationCode();

    public abstract String getTitle();

    public void onInitialRFAB(RapidFloatingActionButton rfab) {
    }

}
