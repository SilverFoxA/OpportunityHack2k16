package in.devmetric.opportunityhackcwdr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginActiviy extends AppCompatActivity
        implements View.OnClickListener {

    private Button bLogin;
    private EditText etEmail, etPassword;
    private TextView tvInvalid, tvForgotPssword, tvRegister;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private String TAG = "LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedpreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        if (sharedpreferences.getBoolean("logged", false)) {
            //user logged in
            startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
        bLogin = (Button) findViewById(R.id.bLogin);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvInvalid = (TextView) findViewById(R.id.tvInvalid);
        tvForgotPssword = (TextView) findViewById(R.id.tvForgotPassowrd);
        tvRegister = (TextView) findViewById(R.id.tvRegister);

        bLogin.setOnClickListener(this);
        tvForgotPssword.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLogin:
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST, AppConfig.LOGIN, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String response) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    editor.putBoolean("logged", true);
                                    editor.commit();
                                    Log.i(TAG, response);
                                    if(!response.isEmpty())
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                                }
                            });
                        }
                    }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(final VolleyError error) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActiviy.this, error.getLocalizedMessage() + "Unable to process your request. Please re-check the details", Toast.LENGTH_SHORT).show();
                                        Log.e("LoginActivity", error.getLocalizedMessage());
                                        tvInvalid.setVisibility(View.VISIBLE);
                                        tvForgotPssword.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                        }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> map = new HashMap<>();
                            map.put("userName", email);
                            map.put("password", password);
                            return map;
                        }
                    };

                    AppController.getInstance().addToRequestQueue(jsonArrayRequest, TAG);
                } else {
                    Toast.makeText(this, "Please enter the details", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvForgotPassowrd:
                Intent i = new Intent(LoginActiviy.this, ForgotPasswordActivity.class);
                startActivity(i);
                break;
            case R.id.tvRegister:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
        }
    }

    private boolean isLoggedIn(String email, String password) {

        return false;
    }
}
