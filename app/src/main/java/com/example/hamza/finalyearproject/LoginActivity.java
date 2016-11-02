package com.example.hamza.finalyearproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.BindViews;

public class LoginActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private static final String TAG = "Login Activity";
    private static final int REQUEST_SIGNUP = 0;
    Button _btnLogin;
    TextView _linkSignup;

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ButterKnife.bind(this);
        _btnLogin = (Button) findViewById(R.id.secondButton);
       _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              Toast.makeText(getApplicationContext(),"working",Toast.LENGTH_SHORT).show();







            }
        });
        _linkSignup = (TextView) findViewById(R.id.link_signup);
        _linkSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,signupActivity.class);
                startActivityForResult(intent,REQUEST_SIGNUP);

            }
        });

    }
// Login Wiring
  /**  public void  login()
    {
        Log.d(TAG,"LOGIN");

        if(!validate())
        {
            OnLoginFailed();
            return;
        }
        _btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email =_emailText.getText().toString();
        String passWord = _passwordText.getText().toString();


        if(email.equals("Hamza") || passWord.equals("1234567"))


        {


            //TODO Authentication Logic

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        @Override
                        public void run() {
                            onLoginSuccess();
                            progressDialog.dismiss();
                        }
                    }


                    , 3000);
        }






    }
   **/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed()
    {

        moveTaskToBack(true);
    }

    public void onLoginSuccess()
    {
        Intent intent = new Intent(LoginActivity.this,signupActivity.class);
        startActivity(intent);
        finish();

    }



    public void OnLoginFailed()
    {
        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT);

       _btnLogin.setEnabled(true);
    }



    public boolean validate()
    {
        boolean valid = true;
        String email = _emailText.getText().toString();
        String passWord = _passwordText.getText().toString();


        if (email.isEmpty() || email!=EMAIL_PATTERN )
        {

            _emailText.setError("Invalid email");
            valid = false;
        }
        else
        {
            _emailText.setError(null);
        }

        if (passWord.isEmpty() || passWord.length() <= 5)
        {
            _passwordText.setError("Invalid Password");
            valid = false;
        }
        else
        {
            _passwordText.setError(null);
        }

        return valid;
    }


}
