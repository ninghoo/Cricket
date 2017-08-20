package com.example.ningfu.cricbroad.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ningfu.cricbroad.R;
import com.example.ningfu.cricbroad.model.ScoreItem;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ningfu on 17-8-19.
 */

public class ScoreItemAdapter extends RecyclerView.Adapter<ScoreItemAdapter.ViewHolder>
{
    private List<ScoreItem> mScores;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView teamImage;

        public ViewHolder(View view)
        {
            super(view);

            teamImage = (CircleImageView) view.findViewById(R.id.item_iv_teamLeft);
        }
    }

    public ScoreItemAdapter(List<ScoreItem> teamsList)
    {
        mScores = teamsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scorelist, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        ScoreItem scoreItem = mScores.get(position);

        holder.teamImage.setImageResource(scoreItem.getTeamLeft());

    }

    @Override
    public int getItemCount() {
        return mScores.size();
    }

}