package com.loftblog.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


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
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        type = getIntent().getStringExtra(EXTRA_TYPE);

        name = findViewById(R.id.name);
        add = findViewById(R.id.add);
        price = findViewById(R.id.name2);


        add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (!add.isEnabled()) {
                    Toast.makeText(AddActivity.this, "Necessary fields not filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent result = new Intent();
                result.putExtra(RESULT_ITEM, new Item(name.getText().toString(), Integer.valueOf(price.getText().toString()), type));
                setResult(RESULT_OK, result);
                finish();
            }
        });

    }



}
