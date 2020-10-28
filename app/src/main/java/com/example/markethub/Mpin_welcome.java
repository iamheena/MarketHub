package com.example.markethub;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mpin_welcome extends AppCompatActivity {
    TextView forget_pass;
    EditText edtipin;
    Toolbar toolbar_mpin;
    boolean ismpinvalid;
    final String PASSWORD_PATTERN = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mpin_page);
        edtipin=(EditText)findViewById(R.id.edt_pin);
        toolbar_mpin=(Toolbar)findViewById(R.id.toolbar_mpin);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar_mpin.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        //edtipin.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtipin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        edtipin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (edtipin.getRight() - edtipin.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        Intent i=new Intent(Mpin_welcome.this,Navigation_drawer.class);
                        startActivity(i);
                        return true;
                    }
                }
                return false;
            }
        });


    }


}
