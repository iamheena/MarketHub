package com.example.markethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {
    Button login,submit;
    Login_activity l;
    Context context;
    SliderLayout sliderLayout;
    TextView guest;
    EditText edt_pass,username;
    TextInputLayout hintView;
    boolean isEmailValid, isPasswordValid, isPasswordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.btn_login);
        submit=(Button)findViewById(R.id.btn_sign_up);
        edt_pass=(EditText)findViewById(R.id.edit_password);
        username=(EditText)findViewById(R.id.edt_email);
     //   hintView=(TextInputLayout)findViewById(R.id.textinput_layout);
     /*   hintView.setHintAnimationEnabled(false);
        hintView.setHint("");*/
        context=this;
        guest=(TextView)findViewById(R.id.guest);
        sliderLayout = findViewById(R.id.imageslider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();


    guest.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(MainActivity.this,Navigation_drawer.class);
            startActivity(i);
        }
    });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  SetValidation();
                Intent i=new Intent(MainActivity.this,Mpin_welcome.class);
                startActivity(i);
            }
        });
        l=new Login_activity();
    }
    public void show(View view)
    {

    }
    public void ShowHidePass(View view) {

        if (view.getId() == R.id.show_pass_btn) {
            if (edt_pass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                ((ImageView) (view)).setImageResource(R.drawable.pass_hide);
                //Show Password
                edt_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                ((ImageView) (view)).setImageResource(R.drawable.visible_pass);
                //Hide Password
                edt_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
    private void setSliderViews() {

        for (int i = 0; i <= 5; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 1:
                    sliderView.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 2:
                    sliderView.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    break;
                case 3:
                    sliderView.setImageUrl("https://imagevars.gulfnews.com/2020/06/22/Dubai_172db8eff9b_large.jpg");
                    break;
                case 4:
                    sliderView.setImageUrl("https://www.bosshunting.com.au/wp-content/uploads/2020/03/RMM_1624703_Sunset_OW_Exterior.jpg");
                    break;
                case 5:
                    sliderView.setImageUrl("https://www.traveldailymedia.com/assets/2018/08/singapore-skyline-1024x576.jpg");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
          //  sliderView.setDescription("setDescription " + (i + 1));
          /*  final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });*/

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
    public void SetValidation() {
        // Check for a valid email address.
        if (username.getText().toString().isEmpty()) {
            username.setError("login");
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(username.getText().toString()).matches()) {
            username.setError("Invalid Username");
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }

        // Check for a valid password.
        if (edt_pass.getText().toString().isEmpty()) {
            edt_pass.setError("valid");
            isPasswordValid = false;
        } else if (edt_pass.getText().length() < 6) {
            edt_pass.setError("Invalide Password");
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
        }

        if (isEmailValid && isPasswordValid) {
            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
        }

    }



}