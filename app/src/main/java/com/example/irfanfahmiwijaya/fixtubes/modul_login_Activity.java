package com.example.irfanfahmiwijaya.fixtubes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.irfanfahmiwijaya.fixtubes.Adapter.users;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.EachExceptionsHandler;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;

public class modul_login_Activity extends AppCompatActivity{

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin, register;
    private ProgressDialog progressDialog;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    final String KEYPREF = "Localdata";
    final String KEYPOSITION = "Position";
    final String KEYUSER = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_login_);

        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.reg);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, String> data = new HashMap<>();
                data.put("username", editTextUsername.getText().toString());
                data.put("password", editTextPassword.getText().toString());

                PostResponseAsyncTask task = new PostResponseAsyncTask(modul_login_Activity.this, data, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        if (!s.contains("Login gagal")) {
                            ArrayList<users> datauser = new JsonConverter<users>().toArrayList(s, users.class);
                            users users = datauser.get(0);
                            editor.putString(KEYUSER, users.id_user);
                            editor.putString(KEYPOSITION, users.nama_user);
                            editor.apply();
                            startActivity(new Intent(modul_login_Activity.this, MainActivity.class));
                        }
                    }
                });

                task.execute("http://192.168.1.11/imageuploadtest/login.php");
                task.setEachExceptionsHandler(new EachExceptionsHandler() {

                    @Override
                    public void handleIOException(IOException e) {
                        Toast.makeText(getApplicationContext(), "Cannot connect to Server", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleMalformedURLException(MalformedURLException e) {
                        Toast.makeText(getApplicationContext(), "URL Error", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleProtocolException(ProtocolException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleUnsupportedEncodingException(UnsupportedEncodingException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(modul_login_Activity.this, modul_register_Activity.class));
            }
        });

        pref = getSharedPreferences(KEYPREF, Context.MODE_PRIVATE);
        editor = pref.edit();
    }


}