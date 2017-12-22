package com.example.raghav.roomdatabasebyshiv.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/*for databse*/
@Database(entities = {Product.class, User.class}, version = 1)
public abstract class ProductDataBase extends RoomDatabase {

    public abstract ProductDao productDao();

    public abstract UserDao userDao();
}
