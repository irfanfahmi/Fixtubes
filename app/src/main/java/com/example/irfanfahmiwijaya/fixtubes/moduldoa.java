package com.example.irfanfahmiwijaya.fixtubes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class moduldoa extends Activity {
    EditText edtStatus;
    Button btnShare;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_doa);
        edtStatus = (EditText) findViewById(R.id.isidoa);
        btnShare = (Button) findViewById(R.id.shareit);
        btnShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String status=edtStatus.getText().toString();
                shareIt(status);
            }
        });
    }
    public void shareIt(String pmessage) {
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "My Status");
        i.putExtra(Intent.EXTRA_TEXT, pmessage);
        startActivity(Intent.createChooser(i,"My Status"));
    }

}
