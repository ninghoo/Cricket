package com.example.ningfu.cricbroad.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ningfu.cricbroad.Application.CricBroadApplication;
import com.example.ningfu.cricbroad.R;
import com.example.ningfu.cricbroad.model.NewsItem;
import com.example.ningfu.cricbroad.model.ScoreItem;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ningfu on 17-8-19.
 */

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder>
{
    private List<NewsItem> mNews;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView newsImage;

        public ViewHolder(View view)
        {
            super(view);

            newsImage = (ImageView) view.findViewById(R.id.item_iv_newsimage);
        }
    }

    public NewsItemAdapter(List<NewsItem> newsList)
    {
        mNews = newsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newslist, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
//        NewsItem newsItem = mNews.get(position);
//
//        holder.newsImage.setImageResource(newsItem.getTeamLeft());

        String url = "drawable://" + R.drawable.pandaya_brothers;

        ImageLoader.getInstance().displayImage(url, holder.newsImage, CricBroadApplication.mOptions);

    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

}