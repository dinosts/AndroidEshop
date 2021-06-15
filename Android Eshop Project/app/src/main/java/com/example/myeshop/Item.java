package com.example.myeshop;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "items")    // To item database poy apo8ikevoume ta items tou magaziou
public class Item {

    public Item(int itid,String iname,String info, int price, int quantity)
    {
        this.itid = itid;
        this.iname = iname;
        this.info = info;
        this.price = price;
        this.quantity = quantity;
    }

    @PrimaryKey @ColumnInfo (name = "itid") @NonNull
    private int itid;                                   // ITEM ID
    @ColumnInfo (name = "iname") @NonNull
    private String iname;                               // ITEM NAME
    @ColumnInfo (name = "info") @NonNull
    private String info;                                // PLIROFORIES GIA TO ITEM
    @ColumnInfo (name = "price") @NonNull
    private int price;                                  // TIMI
    @ColumnInfo (name = "quant") @NonNull
    private int quantity;                               // POSOTITA



    public int getItid() {
        return itid;
    }

    public void setItid(int itid) {
        this.itid = itid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
