package in.devmetric.opportunityhackcwdr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActiviy extends AppCompatActivity
        implements View.OnClickListener {

    private Button bLogin;
    private EditText etEmail, etPassword;
    private TextView tvInvalid, tvForgotPssword, tvRegister;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;

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
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if (email.equals("satyam@gmail.com") && password.equals("danydude")) {
                    editor.putBoolean("logged", true);
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                } else {
                    tvInvalid.setVisibility(View.VISIBLE);
                    tvForgotPssword.setVisibility(View.VISIBLE);
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
}
