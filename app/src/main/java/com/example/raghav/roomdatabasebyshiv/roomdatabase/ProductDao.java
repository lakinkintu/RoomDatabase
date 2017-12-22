package com.example.raghav.roomdatabasebyshiv.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/*for query*/
@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<Product> PRODUCT_LIST();

    @Insert
    void insertProduct(Product product);

    @Update
    void updateProduct(Product product);

    @Delete()
    void deleteProduct(Product product);
}

