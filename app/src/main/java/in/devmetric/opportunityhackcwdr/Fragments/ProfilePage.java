package in.devmetric.opportunityhackcwdr.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import in.devmetric.opportunityhackcwdr.MainActivity;
import in.devmetric.opportunityhackcwdr.ProfileEditActivity;
import in.devmetric.opportunityhackcwdr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePage extends Fragment {


    public ProfilePage() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_page, container, false);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.profile, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit) {
            startActivity(new Intent(getContext(), ProfileEditActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
