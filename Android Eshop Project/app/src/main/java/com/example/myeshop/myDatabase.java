package com.example.myeshop;

import androidx.room.Database;

@Database(entities = {User.class, Item.class, Transaction.class, userCart.class, MainTransaction.class}, version = 1)
public abstract class myDatabase extends androidx.room.RoomDatabase {
    public abstract theDao theDao();
}
