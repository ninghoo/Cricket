package com.example.ningfu.cricbroad.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by ningfu on 17-3-24.
 */

public class WebFragment extends Fragment
{
    public static final String BUNDLE_TITLE = "title";
    private String mTitle = "DefaultValue";

    // 如果return为空，会使得viewpagerIndicator出现卡顿。
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Bundle arguments = getArguments();
        if (arguments != null)
        {
            mTitle = arguments.getString(BUNDLE_TITLE);
        }

        TextView tv = new TextView(getActivity());
        tv.setText(mTitle);
        tv.setGravity(Gravity.CENTER);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });


        return tv;


//        Bundle arguments = getArguments();
//        if (arguments != null)
//        {
//            mTitle = arguments.getString(BUNDLE_TITLE);
//        }
//
//        LinearLayout ll = new LinearLayout(getActivity());
////        ll.setText(mTitle);
//        ll.setGravity(Gravity.CENTER);
//
//        ll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Toast.makeText(getActivity(), "touch", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        return ll;
    }

    public static WebFragment newInstance(String title)
    {
        // 这里是Fragment的实例方法，activity通过newInstance来实例化fragment，同时进行绑定，然后在onCreateView里面来读取绑定的键值对。
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        WebFragment fragment = new WebFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}