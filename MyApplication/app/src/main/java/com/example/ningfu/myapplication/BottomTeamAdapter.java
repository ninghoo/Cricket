package com.example.ningfu.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ningfu on 17-8-19.
 */

public class BottomTeamAdapter extends RecyclerView.Adapter<BottomTeamAdapter.ViewHolder>
{
    private List<Teams> mTeams;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView teamImage;

        public ViewHolder(View view)
        {
            super(view);

            teamImage = (ImageView) view.findViewById(R.id.item_iv_bottomteamimage);
        }
    }

    public BottomTeamAdapter(List<Teams> teamsList)
    {
        mTeams = teamsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bottombar, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Teams teams = mTeams.get(position);

        holder.teamImage.setImageResource(teams.getTeamImageId());

    }

    @Override
    public int getItemCount() {
        return mTeams.size();
    }

}
