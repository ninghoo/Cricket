package com.example.ningfu.cricbroad.Application;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.example.ningfu.cricbroad.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by ningfu on 17-8-21.
 */

public class CricBroadApplication extends Application
{
    // 由于是private属性，所以只要是自己的子类就可以直接访问和保存变量了。
    private  static Context mContext;

    public static DisplayImageOptions mOptions;

    @Override
    public void onCreate()
    {
        super.onCreate();

        // 在onCreate中获取全局的context对象，并在getContext方法中返回。
        mContext = getApplicationContext();

        initImageLoader(this);
    }

    // static的变量，通过static的方法来获取。
    public static Context getContext()
    {
        return mContext;
    }

    // 在Application中去初始化对ImageLoader的配置。
    private void initImageLoader(Context context)
    {

        // 第一步是
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(200 * 1024 * 1024) // 200 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                //.writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);


        mOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.oafront)
                .showImageForEmptyUri(R.drawable.oafront)
                .showImageOnFail(R.drawable.oafront)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }
}