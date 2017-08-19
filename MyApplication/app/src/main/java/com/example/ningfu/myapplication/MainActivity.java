package com.example.ningfu.myapplication;

import android.os.health.PackageHealthStats;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<Teams> teamsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBottomBar();
    }

    private void initBottomBar()
    {
        initTeams();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recy);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        BottomTeamAdapter adapter = new BottomTeamAdapter(teamsList);

        recyclerView.setAdapter(adapter);
    }

    private void initTeams()
    {
        teamsList.add(new Teams(R.drawable.delhi));
        teamsList.add(new Teams(R.drawable.gujaratlions));
        teamsList.add(new Teams(R.drawable.kingsxi));
        teamsList.add(new Teams(R.drawable.knightriders));
        teamsList.add(new Teams(R.drawable.mumbaiindians));
        teamsList.add(new Teams(R.drawable.royalchallengers));
        teamsList.add(new Teams(R.drawable.rsingpune));
        teamsList.add(new Teams(R.drawable.sunrisershyderabad));
        teamsList.add(new Teams(R.drawable.current));

    }
}
