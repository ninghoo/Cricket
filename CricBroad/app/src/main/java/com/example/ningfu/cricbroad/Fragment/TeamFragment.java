package com.example.ningfu.cricbroad.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ningfu.cricbroad.Adapter.ScoreItemAdapter;
import com.example.ningfu.cricbroad.R;
import com.example.ningfu.cricbroad.model.ScoreItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ningfu on 17-8-19.
 */

public class TeamFragment extends Fragment
{
    private List<ScoreItem> scoreItemList = new ArrayList<>();
    private RecyclerView recyclerView;

    public static final String BUNDLE_TITLE = "title";
    private String mTitle = "DefaultValue";

    private View view;

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

        view = inflater.inflate(R.layout.fragment_scorerecycler, container, false);

        initData();

        initScoreRecyClerView();

        return view;
    }

    public static TeamFragment newInstance(String title)
    {
        // 这里是Fragment的实例方法，activity通过newInstance来实例化fragment，同时进行绑定，然后在onCreateView里面来读取绑定的键值对。
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        TeamFragment fragment = new TeamFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void initData()
    {
        for(int i = 0; i < 8; i ++)
        {
            ScoreItem scoreItem = new ScoreItem(R.drawable.delhi);

            scoreItemList.add(scoreItem);
        }
    }

    private  void initScoreRecyClerView()
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycl_scorelist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ScoreItemAdapter adapter = new ScoreItemAdapter(scoreItemList);
        recyclerView.setAdapter(adapter);
    }
}

