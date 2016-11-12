package in.devmetric.opportunityhackcwdr.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.devmetric.opportunityhackcwdr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsPage extends Fragment {


    public QuestionsPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_page, container, false);
    }

}
