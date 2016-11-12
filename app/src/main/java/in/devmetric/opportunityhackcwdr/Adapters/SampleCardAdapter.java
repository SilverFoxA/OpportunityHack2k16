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

import in.devmetric.opportunityhackcwdr.R;

/**
 * Created by @silverFoxA on 12/11/16.
 */

public class SampleCardAdapter extends RecyclerView.Adapter {


    private HashSet list;

    public SampleCardAdapter(Context mContext) {

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
        new SampleFeedHolder(holder.itemView).bindData();
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class SampleFeedHolder extends RecyclerView.ViewHolder {


        SampleFeedHolder(View itemView) {
            super(itemView);
            //initialise variables

        }


        public void bindData() {//perform operations here

        }

    }


}