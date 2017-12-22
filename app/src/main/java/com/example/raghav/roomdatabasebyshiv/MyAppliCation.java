package com.example.raghav.roomdatabasebyshiv;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.raghav.roomdatabasebyshiv.roomdatabase.ProductDataBase;

/**
 * Created by raghav on 22/12/17.
 */

public class MyAppliCation extends Application{

    public static ProductDataBase productDataBase;
    @Override
    public void onCreate() {
        super.onCreate();
        productDataBase = Room.databaseBuilder(this, ProductDataBase.class, "ProductDataBase").build();
    }
}
