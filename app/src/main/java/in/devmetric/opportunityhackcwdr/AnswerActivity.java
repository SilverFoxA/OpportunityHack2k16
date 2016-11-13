package in.devmetric.opportunityhackcwdr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import in.devmetric.opportunityhackcwdr.Pojo.SearchPojo;

public class AnswerActivity extends AppCompatActivity {

    private EditText answer;
    private Button post;
    private TextView QuestionTitle, QuestionDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        QuestionTitle = (TextView) findViewById(R.id.QuestionTitle);
        QuestionTitle.setVisibility(View.GONE);
        QuestionDesc = (TextView) findViewById(R.id.QuestionDesc);

        SearchPojo searchPojo = (SearchPojo) getIntent().getSerializableExtra("value");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(searchPojo.getSource().getTitle());
        }
//        QuestionTitle.setText(searchPojo.getSource().getTitle());
        QuestionDesc.setText(searchPojo.getSource().getDescription());

//        answer = (EditText) findViewById(R.id.answer);
//        post.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
