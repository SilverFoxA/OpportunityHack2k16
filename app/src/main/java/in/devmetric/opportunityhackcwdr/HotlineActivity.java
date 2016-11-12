package in.devmetric.opportunityhackcwdr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HotlineActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotline);

        recyclerView = (RecyclerView) findViewById(R.id.recyalerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new  LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HotlineAdapter(getData());
        recyclerView.setAdapter(adapter);
    }

    ArrayList<Hotline> getData() {
        ArrayList<Hotline> hotList = new ArrayList<>();

        hotList.add(new Hotline("Satyam Rai", "9591480346", "Bangalore"));
        hotList.add(new Hotline("Abhijit Das", "9591480346", "Bangalore"));
        hotList.add(new Hotline("Kiran", "9591480346", "Bangalore"));
        hotList.add(new Hotline("Shashank", "9591480346", "Bangalore"));

        return hotList;
    }

    class HotlineAdapter extends RecyclerView.Adapter
            <HotlineActivity.HotlineViewHolder> {

        ArrayList<Hotline> mDataSet;

        public HotlineAdapter(ArrayList<Hotline> mDataSet) {
            this.mDataSet = mDataSet;
        }

        @Override
        public HotlineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotline_card, parent, false);
            return new HotlineViewHolder(view);
        }

        @Override
        public void onBindViewHolder(HotlineViewHolder holder, int position) {
            holder.tvName.setText(mDataSet.get(position).getName());
            holder.tvNumber.setText(mDataSet.get(position).getNumber());
            holder.tvLocation.setText(mDataSet.get(position).getLocation());
            holder.tvInitial.setText(mDataSet.get(position).getName().charAt(0)+"");
        }

        @Override
        public int getItemCount() {
            return mDataSet.size();
        }
    }

    class HotlineViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvNumber, tvLocation, tvInitial;
        public HotlineViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvNumber = (TextView) itemView.findViewById(R.id.tvNumber);
            tvLocation = (TextView) itemView.findViewById(R.id.tvLocation);
            tvInitial = (TextView) itemView.findViewById(R.id.tvInitial);
        }
    }
}
