package com.example.moviecatalogueuiux.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.moviecatalogueuiux.R;
import com.example.moviecatalogueuiux.fragment.FilmFragment;
import com.example.moviecatalogueuiux.fragment.TVFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    private final Context context;

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FilmFragment();
            case 1:
                return new TVFragment();
        }

        return null;
    }

    @SuppressWarnings("SameReturnValue")
    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.movie);
            case 1:
                return context.getResources().getString(R.string.tv_show);
            default:
                return null;
        }
    }
}
