package in.devmetric.opportunityhackcwdr.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import in.devmetric.opportunityhackcwdr.PostDescription;
import in.devmetric.opportunityhackcwdr.R;

/**
 * Created by @silverFoxA on 12/11/16.
 */

public class SampleCardAdapter extends RecyclerView.Adapter {


    private final Context mContext;
    private HashSet list;

    public SampleCardAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        RecyclerView.ViewHolder vh;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_item, parent, false);

        vh = new SampleFeedHolder(view);

        return vh;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int pos) {
        new SampleFeedHolder(holder.itemView).bindData(mContext);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class SampleFeedHolder extends RecyclerView.ViewHolder {

        private ImageView wallpaper;
        private TextView postTitle, postDescription;

        SampleFeedHolder(View itemView) {
            super(itemView);
            //initialise variables
            wallpaper = (ImageView) itemView.findViewById(R.id.wallpaper);
            postTitle = (TextView) itemView.findViewById(R.id.postTitle);
            postDescription = (TextView) itemView.findViewById(R.id.txtDescription);
        }


        public void bindData(final Context mContext) {//perform operations here
            wallpaper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCommon();
                }
            });
            postTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCommon();
                }
            });
            postDescription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCommon();
                }
            });


        }

        private void mCommon() {
            mContext.startActivity(new Intent(mContext, PostDescription.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }

    }


}