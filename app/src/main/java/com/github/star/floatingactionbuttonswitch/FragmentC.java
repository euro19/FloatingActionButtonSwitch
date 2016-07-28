package com.github.star.floatingactionbuttonswitch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.listener.OnRapidFloatingButtonSeparateListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentC extends BaseFragment implements OnRapidFloatingButtonSeparateListener {

    private RapidFloatingActionButton rfaButton;

    public FragmentC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false);
    }


    @Override
    public String getRfabIdentificationCode() {
        return getString(R.string.rfab_identification_code_fragment_c);
    }

    @Override
    public String getTitle() {
        return this.getClass().getSimpleName();
    }


    @Override
    public void onInitialRFAB(RapidFloatingActionButton rfab) {
        this.rfaButton = rfab;
        if (null == rfaButton) {
            return;
        }
        rfaButton.setOnRapidFloatingButtonSeparateListener(this);
    }

    @Override
    public void onRFABClick() {
        Toast.makeText(getContext(), "FragmentC", Toast.LENGTH_SHORT).show();
    }
}
