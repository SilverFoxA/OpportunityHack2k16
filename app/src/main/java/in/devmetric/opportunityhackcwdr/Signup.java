package in.devmetric.opportunityhackcwdr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    private static final String TAG = "SIGNUP_ACTIVITY";
    private Button register;
    private EditText name;
    private EditText contact;
    private EditText email;
    private CheckBox option1;
    private CheckBox option2;
    private CheckBox option3;
    private CheckBox option4;
    private EditText password;
    private EditText preferences;
    private EditText age;
    private EditText qualification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        register = (Button)findViewById(R.id.register);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        contact = (EditText)findViewById(R.id.contact);
        option1 = (CheckBox)findViewById(R.id.option1);
        option2 = (CheckBox)findViewById(R.id.option2);
        option3 = (CheckBox)findViewById(R.id.option3);
        option4 = (CheckBox)findViewById(R.id.option4);
        password = (EditText)findViewById(R.id.password1);
        age = (EditText) findViewById(R.id.age);
        qualification = (EditText) findViewById(R.id.qualification);
        preferences = (EditText) findViewById(R.id.preferences);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast ;
                toast = Toast.makeText(Signup.this,"",Toast.LENGTH_LONG);
                Boolean flag = false;
                if(name.getText().length() > 0&&contact.getText().length() > 0&&email.getText().length() > 0&&password.getText().length() >0){
                    flag = true;
                }
                else {
                    flag = false;
                    //toast.cancel();
                    toast.setText("Please Enter all Fields");
                    toast.show();
                }

                if(flag == true){
                        StringRequest request = new StringRequest(Request.Method.POST, AppConfig.USER, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.i(TAG, response);
                                if(!TextUtils.isEmpty(response)) {
                                    Intent in = new Intent(Signup.this, MainActivity.class);
                                    startActivity(in);
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<String, String>();

                                String sname = name.getText().toString();
                                String semail = email.getText().toString();
                                String scontact = contact.getText().toString();
                                String spassword = password.getText().toString();
                                String sage = age.getText().toString();
                                //String spreferences = preferences.getText().toString();
                                String squalification = qualification.getText().toString();

                                params.put("fullName", sname);
                                //params.put("preferences", spreferences);
                                params.put("email", semail);
                                params.put("password", spassword);
                                params.put("phone", scontact);
                                params.put("age", sage);
                                params.put("qualification", squalification);
                                Log.i(TAG, sname);

                                return params;
                            }
                        };

                        AppController.getInstance().addToRequestQueue(request, TAG);
                    }


            }
        });

    }
}
