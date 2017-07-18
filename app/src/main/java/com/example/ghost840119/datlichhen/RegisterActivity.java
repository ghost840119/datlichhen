package com.example.ghost840119.datlichhen;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ghost840119.datlichhen.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class RegisterActivity extends AppCompatActivity {
    EditText edtUsername,edtPassword,edtRelayPass;
    Button btnRegister,btnCancel;
    private FirebaseAuth mAuth;
    private DatabaseReference mData;
    private static final String TAG = "RegisterActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        mAuth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance().getReference();
        mapper();
    }
    private void mapper(){
        edtUsername = (EditText) findViewById(R.id.edtusername);
        edtPassword = (EditText) findViewById(R.id.edtpassword);
        edtRelayPass = (EditText)findViewById(R.id.edtRelayPass);

        btnRegister = (Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtUsername.getText()== null && edtPassword.getText() == null && edtRelayPass.getText()== edtPassword.getText()){
                    Toast.makeText(RegisterActivity.this, "Not null",
                            Toast.LENGTH_SHORT).show();
                }else {
                    registerUser(edtUsername.getText().toString(), edtPassword.getText().toString());
                }
            }
        });
        btnCancel = (Button)findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void registerUser(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            mData.child("nguoidung").push().setValue(new User(user.getDisplayName(),user.getEmail(),user.getUid()));
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });
    }
    private void updateUI(FirebaseUser user){
        Log.d(TAG, user.toString());
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class );
        startActivity(intent);
    }
    private List<User> GetListUser(){
        final List<User> listUser = new ArrayList<>();
        mData.child("nguoidung").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
                listUser.add(user);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return listUser;
    }
}
