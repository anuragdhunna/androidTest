package com.viithiisys.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viithiisys.android.myplayapplication.R;

/**
 * Created by anuragdhunna on 27/10/17.
 */

public class PM_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pm_fragment, container, false);
    }
}
