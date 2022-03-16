package com.xampweb.yourchats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.xampweb.yourchats.Models.Users;
import com.xampweb.yourchats.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        auth =FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        dialog = new ProgressDialog(SignUpActivity.this);
        dialog.setTitle("Creating Account");
        dialog.setMessage("We're Creating Your Account...");


        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etUserName.getText().toString().isEmpty()){
                    binding.etUserName.setError("Enter Your User Name");
                    return;
                }
                if (binding.etPhone.getText().toString().trim().length()<10){
                    binding.etPhone.setError("Enter 10 Digits Phone Number");
                    return;
                }
                if (binding.etEmail.getText().toString().isEmpty()){
                    binding.etEmail.setError("Enter Your Email");
                    return;
                }
                if (binding.etPassword.getText().toString().isEmpty()){
                    binding.etPassword.setError("Enter Your Password");
                    return;
                }

                dialog.show();
                auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(),
                        binding.etPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        dialog.dismiss();

                        if (task.isSuccessful())
                        {

                            Users user = new Users(binding.etUserName.getText().toString(),
                                    binding.etPhone.getText().toString(),
                                    binding.etEmail.getText().toString(),
                                    binding.etPassword.getText().toString());
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);
                            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                            startActivity(intent);
                            SignUpActivity.this.finish();


                            Toast.makeText(SignUpActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        binding.tvAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);

            }
        });






    }
}