package com.sourceit.sourceit4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PHONE_REGEX =
            Pattern.compile("\\+38[0-9]{10}", Pattern.CASE_INSENSITIVE);

    EditText etLogin;
    EditText etEmail;
    EditText etTelephone;
    EditText etPassword;
    EditText etConfirmPassword;

    TextView tvStatus;
    Button btnSubmit;

    String login;
    String email;
    String telephone;
    String password;
    String confirmPassword;

    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = (EditText) findViewById(R.id.et_login);
        etEmail = (EditText) findViewById(R.id.et_email);
        etTelephone = (EditText) findViewById(R.id.et_telephone);
        etPassword = (EditText) findViewById(R.id.et_password);
        etConfirmPassword = (EditText) findViewById(R.id.et_confirm_password);

        tvStatus = (TextView) findViewById(R.id.tv_text);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserData();
                status = checkUserData();
                tvStatus.setText(status);
            }
        });

    }


    private void getUserData() {

        login = etLogin.getText().toString();
        email = etEmail.getText().toString();
        telephone = etTelephone.getText().toString();
        password = etPassword.getText().toString();
        confirmPassword = etConfirmPassword.getText().toString();

        System.out.println(login);
        System.out.println(email);
        System.out.println(telephone);
        System.out.println(password);
        System.out.println(confirmPassword);

    }

    private String checkUserData() {

        System.out.println(login);
        System.out.println(email);
        System.out.println(telephone);
        System.out.println(password);
        System.out.println(confirmPassword);
        if (login.length() == 0) {
            return "Enter login";
        } else if (email.length() == 0) {
            return "Enter email";
        } else if (!validateEmail(email)) {
            return "Incorrect email";
        } else if (telephone.length() == 0) {
            return "Enter telephone";
        } else if (!validatePhone(telephone)) {
            return "Incorrect telephone";
        } else if (password.length() == 0) {
            return "Enter password";
        } else if (confirmPassword.length() == 0) {
            return "Confirm your password";
        } else if (!confirmPassword.equals(password)) {
            return "Passwords do not match";
        } else {
            return "Валидация пройдена!";
        }


    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean validatePhone(String phoneStr) {
        Matcher matcher = VALID_PHONE_REGEX.matcher(phoneStr);
        return matcher.find();
    }
}


