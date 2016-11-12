package in.devmetric.opportunityhackcwdr.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.devmetric.opportunityhackcwdr.Adapters.SampleCardAdapter;
import in.devmetric.opportunityhackcwdr.R;
import in.devmetric.opportunityhackcwdr.ViewHolders.MainFeedHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainHomePage extends Fragment {

    private MainFeedHolder mainFeedHolder;

    public MainHomePage() {
        mainFeedHolder = new MainFeedHolder();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_home_page, container, false);

        //Recyclerview
        mainFeedHolder.recyclerView = (RecyclerView) view.findViewById(R.id.home_feeds);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mainFeedHolder.recyclerView.setLayoutManager(linearLayoutManager);
        mainFeedHolder.recyclerView.setHasFixedSize(true);
        mainFeedHolder.recyclerView.setItemViewCacheSize(20);
        mainFeedHolder.recyclerView.setDrawingCacheEnabled(true);
        mainFeedHolder.recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        //adapter
        SampleCardAdapter adapter = new SampleCardAdapter(getContext());
        mainFeedHolder.recyclerView.setAdapter(adapter);

        return view;
    }

}
