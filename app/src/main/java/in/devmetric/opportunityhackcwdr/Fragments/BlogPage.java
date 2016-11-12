package in.devmetric.opportunityhackcwdr.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import in.devmetric.opportunityhackcwdr.Adapters.SampleCardAdapter;
import in.devmetric.opportunityhackcwdr.Add_New_Post;
import in.devmetric.opportunityhackcwdr.MainActivity;
import in.devmetric.opportunityhackcwdr.R;
import in.devmetric.opportunityhackcwdr.ViewHolders.MainFeedHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogPage extends Fragment {
    private MainFeedHolder mainFeedHolder;

    public BlogPage() {
        mainFeedHolder = new MainFeedHolder();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog_page, container, false);
        //add blog
        mainFeedHolder.addLayout = (RelativeLayout) view.findViewById(R.id.addLayout);
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


        mainFeedHolder.recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    mainFeedHolder.addLayout.setVisibility(View.GONE);
                } else {
                    mainFeedHolder.addLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        mainFeedHolder.addLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Add_New_Post.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        return view;
    }

}
