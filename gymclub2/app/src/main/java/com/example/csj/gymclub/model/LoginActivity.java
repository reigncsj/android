package com.example.csj.gymclub.model;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.csj.gymclub.R;
import com.example.csj.gymclub.http.HttpCallbackListener;
import com.example.csj.gymclub.http.HttpSettings;
import com.example.csj.gymclub.http.HttpUtil;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */


    // UI references.
    private AutoCompleteTextView mIdView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mIdView= (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mIdView.getText().toString();
                String pwd = mPasswordView.getText().toString();
                if (id.length() <= 4 || id.length() > 20) {
                    Toast toast = Toast.makeText(LoginActivity.this, "账号输入应该在5-20位", Toast.LENGTH_SHORT);
                    mIdView.setText("");
                    toast.show();
                } else if (pwd.length() <= 5 || pwd.length() > 20) {
                    Toast toast = Toast.makeText(LoginActivity.this, "密码输入应该在6-20位", Toast.LENGTH_SHORT);
                    mPasswordView.setText("");
                    toast.show();
                } else {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("user_id", id);
                    map.put("pwd", pwd);

                    HttpUtil.sendHttpPostRequest(HttpSettings.httpUrl + HttpSettings.loginUrl, map, new HttpCallbackListener() {
                        @Override
                        public void onFinish(String response) {
                            try {
                                JSONObject res = new JSONObject(response);
                                String result = res.getString("result");
                                if (result.equals("true")) {
                                    JSONObject data = res.getJSONObject("data");
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    i.putExtra("name", data.getString("name"));
                                    i.putExtra("phone", data.getString("phone"));
                                    startActivity(i);
                                } else {
                                    Looper.prepare();
                                    Toast toast = Toast.makeText(LoginActivity.this, "密码错误或者账号不存在", Toast.LENGTH_SHORT);
                                    mIdView.setText("");
                                    mPasswordView.setText("");
                                    toast.show();
                                    Looper.loop();
                                }
                            } catch (Exception e) {
                                Looper.prepare();
                                Toast toast = Toast.makeText(LoginActivity.this, "密码错误或者账号不存在", Toast.LENGTH_SHORT);
                                mIdView.setText("");
                                mPasswordView.setText("");
                                toast.show();
                                Looper.loop();
                            }

                        }

                        @Override
                        public void onError(Exception e) {
                            Looper.prepare();
                            Toast toast = Toast.makeText(LoginActivity.this, "登录失败,请检查网络", Toast.LENGTH_SHORT);
                            mIdView.setText("");
                            mPasswordView.setText("");
                            toast.show();
                            Looper.loop();
                        }
                    });

                }
            }
        });
        Button mEmailSignInButton1 = (Button) findViewById(R.id.email_sign_in_button1);
        mEmailSignInButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //attemptLogin();
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }


}


