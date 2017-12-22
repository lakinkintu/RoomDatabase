package com.example.raghav.roomdatabasebyshiv;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.raghav.roomdatabasebyshiv.roomdatabase.Product;
import com.example.raghav.roomdatabasebyshiv.roomdatabase.ProductDataBase;
import com.example.raghav.roomdatabasebyshiv.roomdatabase.User;

import java.util.List;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    ProductDataBase productDataBase;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.read).setOnClickListener(this);
        findViewById(R.id.insert).setOnClickListener(this);
        ProductDataBase productDataBase = Room.databaseBuilder(UserActivity.this, ProductDataBase.class, "ProductDataBase").allowMainThreadQueries().build();

        user = new User();
        user.setUser_email("abc@gmail.com");
        user.setUser_name("Raman Raghav");
        user.setUser_password("123@abc");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                productDataBase.userDao().userDataInsert(user);
                break;
            case R.id.read:
                List<User> users = productDataBase.userDao().userList();
                Log.d("read data", String.valueOf(users.size()));
                break;
            case R.id.update:

                break;
            case R.id.delete:

                break;
        }
    }
}
