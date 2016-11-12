package in.devmetric.opportunityhackcwdr.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashSet;

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

        ImageView imgFrwd;

        SampleFeedHolder(View itemView) {
            super(itemView);
            //initialise variables

        }


        public void bindData() {//perform operations here

        }

    }


}