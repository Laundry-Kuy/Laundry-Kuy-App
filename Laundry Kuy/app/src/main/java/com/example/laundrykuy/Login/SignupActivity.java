package com.example.laundrykuy.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laundrykuy.Model.Request;
import com.example.laundrykuy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignupActivity extends AppCompatActivity {

    private EditText mEmail, mPassword,mAlamat,mNama,mTelpon;
    private Button tLogin, mRegistration;
    private CheckBox checkBox;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    private ProgressDialog loading;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getWindow().setStatusBarColor(getResources().getColor(R.color.abu2));
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        database = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if ((user!=null)){
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        mNama = findViewById(R.id.et_nama);
        mTelpon = findViewById(R.id.et_telpon);
        mAlamat = findViewById(R.id.et_alamat);
        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        tLogin = findViewById(R.id.sign_in_button);
        mRegistration = findViewById(R.id.sign_up_button);

        checkBox = findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else {
                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });

        mRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Snama = mNama.getText().toString();
                final String Stelpon = mTelpon.getText().toString();
                final String Salamat = mAlamat.getText().toString();
                final String Sfoto = "";

                final String Semail = mEmail.getText().toString();
                final String Spassword = mPassword.getText().toString();

                if (Snama.equals("")){
                    mNama.setError("Masukkan nama terlebih dahulu!");
                    mNama.requestFocus();
                }
                else if (Stelpon.equals("")){
                    mTelpon.setError("Masukkan no telpon terlebih dahulu!");
                    mTelpon.requestFocus();
                }
                else if (Salamat.equals("")){
                    mAlamat.setError("Masukkan deskripsi terlebih dahulu!");
                    mAlamat.requestFocus();
                }
                else if (Semail.equals("")){
                    mEmail.setError("Masukkan email terlebih dahulu!");
                    mEmail.requestFocus();
                }

                else if (Spassword.equals("")){
                    mPassword.setError("Masukkan password terlebih dahulu!");
                    mPassword.requestFocus();
                }

                else {
                    loading = ProgressDialog.show(SignupActivity.this,
                            "",
                            "Please wait...",
                            true,
                            false);

                    mAuth.createUserWithEmailAndPassword(Semail, Spassword).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()){
                                loading.dismiss();
                                Toast.makeText(SignupActivity.this, "Sign Up error!", Toast.LENGTH_SHORT).show();
                            }else {
                                submitUser(new Request(
                                        Snama,
                                        Stelpon,
                                        Salamat,
                                        Semail,
                                        Sfoto
                                ));
                            }
                        }
                    });


                }
            }
        });


        tLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

    private void submitUser(Request request) {
        String user_id = mAuth.getCurrentUser().getUid();
        database.child("Users")
                .child(user_id)
                .setValue(request)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        loading.dismiss();

                        mNama.setText("");
                        mTelpon.setText("");
                        mAlamat.setText("");
                        mEmail.setText("");
                        mPassword.setText("");

                        Toast.makeText(SignupActivity.this, "Daftar berhasil!", Toast.LENGTH_SHORT).show();
                        finish();
                        return;

                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }
}