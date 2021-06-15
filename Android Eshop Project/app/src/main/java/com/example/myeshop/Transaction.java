package com.example.myeshop;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.example.myeshop.Item;

@Entity(tableName = "transactions",
        primaryKeys={"tid","mainid"},
        foreignKeys= {
        @ForeignKey(entity = Item.class,
        parentColumns = "itid",
        childColumns = "tiid",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = MainTransaction.class,
        parentColumns = "tid",
        childColumns = "mainid",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)
})
public class Transaction {                          // Item transaction opou exoun h ka8e mia ena id alla anikoun se ena Maintransaction



    @ColumnInfo(name = "tid") @NonNull
    private int id;                                 // TO ID
    @ColumnInfo(name = "mainid") @NonNull
    private int mainid;                             // Main transaction id
    @ColumnInfo (name = "tiid") @NonNull
    private int tiid;                               // item id
    @ColumnInfo (name = "iquant") @NonNull
    private int iquant;                             // quantity

    public Transaction(int id, int mainid, int tiid, int iquant) {
        this.id = id;
        this.mainid = mainid;
        this.tiid = tiid;
        this.iquant = iquant;
    }

    public int getMainid() {
        return mainid;
    }

    public void setMainid(int mainid) {
        this.mainid = mainid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTiid() {
        return tiid;
    }

    public void setTiid(int tiid) {
        this.tiid = tiid;
    }

    public int getIquant() {
        return iquant;
    }

    public void setIquant(int iquant) {
        this.iquant = iquant;
    }
}
