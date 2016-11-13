package in.devmetric.opportunityhackcwdr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import in.devmetric.opportunityhackcwdr.Pojo.SearchPojo;

public class PostDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SearchPojo searchPojo = (SearchPojo) getIntent().getSerializableExtra("value");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(searchPojo.getSource().getTitle() + "");
        }
        ((TextView) findViewById(R.id.description)).setText(searchPojo.getSource().getData());

    }
}
