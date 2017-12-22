package com.example.raghav.roomdatabasebyshiv;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raghav.roomdatabasebyshiv.roomdatabase.Product;
import com.example.raghav.roomdatabasebyshiv.roomdatabase.ProductDataBase;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProductDataBase productDataBase;
    Product product;
    private android.widget.EditText username;
    private android.widget.EditText useremail;
    private android.widget.TextView userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.userlist = (TextView) findViewById(R.id.userlist);
        this.useremail = (EditText) findViewById(R.id.useremail);
        this.username = (EditText) findViewById(R.id.username);
        ;
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.read).setOnClickListener(this);
        findViewById(R.id.insert).setOnClickListener(this);
        productDataBase = Room.databaseBuilder(MainActivity.this, ProductDataBase.class, "ProductDataBase").allowMainThreadQueries().build();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                insertData();
                // productDataBase.productDao().insertProduct(product);
                break;
            case R.id.read:
                readData();
                break;
            case R.id.update:
                product = new Product();
                product.setName("Book");
                product.setEmail("abc@gmail.com");
                product.setPid(1);
                productDataBase.productDao().updateProduct(product);
                break;
            case R.id.delete:
                product = new Product();
                product.setName("Shiv Kumar");
                product.setEmail("xyz@gmail.com");
                product.setPid(10);
                productDataBase.productDao().deleteProduct(product);
                break;
        }
    }

    public void readData() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Product> products = productDataBase.productDao().PRODUCT_LIST();
        Log.d("read data", String.valueOf(products.size()));
        for (int i = 0; i < products.size(); i++) {
            stringBuilder.append("\nUid :" + products.get(i).getPid() + ", Name" + products.get(i).getName() + ", Email" + products.get(i).getEmail());
        }
        userlist.setText(stringBuilder.toString());
    }

    public void insertData() {

        if (username.getText().toString().isEmpty())
            Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
        else if (useremail.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
        } else {
            product = new Product();
            product.setEmail(useremail.getText().toString());
            product.setName(username.getText().toString());
            productDataBase.productDao().insertProduct(product);
            Toast.makeText(this, "Insert Successfuly", Toast.LENGTH_SHORT).show();
        }

    }
}
