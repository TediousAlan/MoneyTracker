package com.loftblog.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


public class AddActivity extends AppCompatActivity {

    public static final String EXTRA_TYPE = "type";
    public static final String RESULT_ITEM = "item";
    public static final int RC_ADD_ITEM = 99;

    private EditText name;
    private EditText price;
    private ImageButton add;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        type = getIntent().getStringExtra(EXTRA_TYPE);

        final EditText titleEdit = findViewById(R.id.name);
        final ImageButton addButton = findViewById(R.id.add);
        final EditText titleEdit2 = findViewById(R.id.name2);


        add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent result = new Intent();
                result.putExtra(RESULT_ITEM, new Item(name.getText().toString(), 100, type));
                setResult(RESULT_OK, result);
                finish();
            }
        });

        titleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (titleEdit.getText().length() != 0 && titleEdit2.getText().length() != 0)
                    addButton.setEnabled(!TextUtils.isEmpty(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        titleEdit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addButton.setEnabled(!TextUtils.isEmpty(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
