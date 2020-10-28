package com.example.markethub;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Login_activity extends AppCompatActivity {
    Toolbar toolbar;
    TextView forgot_pass_welcome,signup;
    Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_login);
        login_btn=(Button)findViewById(R.id.logInBtn);
        forgot_pass_welcome=(TextView)findViewById(R.id.forgot_pass_welcome);
        signup=(TextView)findViewById(R.id.singn_up);
        //will hide the title
       // getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        forgot_pass_welcome.setMovementMethod(LinkMovementMethod.getInstance());
        forgot_pass_welcome.setClickable(true);
      //  forgot_pass_welcome.setTextColor(Color.BLUE);
        signup.setMovementMethod(LinkMovementMethod.getInstance());
        signup.setClickable(true);
      //  signup.setTextColor(Color.BLUE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login_activity.this,Mpin_welcome.class);
                startActivity(i);
            }
        });
    }
}

    /*View  view1;
    Button LoginPop;
    RadioButton email,userId;
    Dialog dialog;
    ImageView cancel;
    RadioGroup radioGroup;*/
    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view1=inflater.inflate(R.layout.sample_login,null);
        LoginPop=(Button)view1.findViewById(R.id.btnpop_login);
        email=(RadioButton) view1.findViewById(R.id.email_id);
        userId=(RadioButton)view1.findViewById(R.id.user_id);
        radioGroup=(RadioGroup)view1.findViewById(R.id.radio_group);
       // userId.setChecked(true);
        cancel=(ImageView)view1.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        userId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dialog.dismiss();
                view1.setVisibility(View.VISIBLE);

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            view1.setVisibility(View.GONE);
            dialog=new Dialog(getActivity());
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.email_dialogue);
                dialog.show();
               // email.setChecked(true);
            ImageView cancel_email=dialog.findViewById(R.id.cancel_email);
            cancel_email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });

            }
        });
        LoginPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),Mpin_welcome.class);
                startActivity(i);
            }
        });
        return view1;
    }*/


