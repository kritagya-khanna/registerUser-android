package com.example.registerpage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText inputName, inputEmail, inputPassword, inputConPass;
    private Button pickImgBtn, registerBtn;
    private RadioGroup genderRadio;
    private CheckBox agreeCheck;
    private RelativeLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();

        pickImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Feature not available yet", Toast.LENGTH_SHORT).show();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkValidation()){
                    if(agreeCheck.isChecked()){
                        Snackbar.make(parent, "Registered succcessfully", Snackbar.LENGTH_INDEFINITE)
                                .setAction("Dismiss", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        inputName.setText("");
                                        inputEmail.setText("");
                                        inputPassword.setText("");
                                        inputConPass.setText("");
                                    }
                                }).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "please tick i agree to continue", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private boolean checkValidation(){
        if(inputName.getText().toString().isEmpty()){
            Toast.makeText(this, "Name field is mandatory", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(inputEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "Email field is mandatory", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(inputPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "password field is mandatory", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(inputConPass.getText().toString().isEmpty()){
            Toast.makeText(this, "confirm password field is mandatory", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(inputPassword.getText().equals(inputConPass.getText())){
            Toast.makeText(this, "password and confirm password does not match", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(genderRadio.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "select your gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void initViews(){
        Log.d(TAG, "initViews: Started");
        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConPass = findViewById(R.id.inputConfirmPassword);

        pickImgBtn = findViewById(R.id.changeImage);
        registerBtn = findViewById(R.id.registerButton);

        genderRadio = findViewById(R.id.genderRadioGroup);
        agreeCheck = findViewById(R.id.agreementCheck);

        parent = findViewById(R.id.main);
    }


}