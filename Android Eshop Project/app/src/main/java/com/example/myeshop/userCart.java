package com.example.myeshop;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "userCart",primaryKeys = "cid",
        foreignKeys= {
                @ForeignKey(entity = Item.class,
                        parentColumns = "itid",
                        childColumns = "ciid",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE),
                @ForeignKey(entity = User.class,
                        parentColumns = "uid",
                        childColumns = "cuid",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        })
public class userCart {                             // USER CART

    public userCart(int cid,String cuid,int ciid,int Quantity) {
        this.cuid = cuid;
        this.ciid = ciid;
        this.Quantity=Quantity;
        this.cid=cid;
    }
    @ColumnInfo (name = "cid") @NonNull
    private int cid;                                // CART ID
    @ColumnInfo (name = "ciid") @NonNull
    private int ciid;                               // ITEM ID
    @ColumnInfo (name = "cuid") @NonNull
    private String cuid;                            // USER ID
    @ColumnInfo (name = "quan") @NonNull
    private int Quantity;                           // quantity

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getCiid() {
        return ciid;
    }

    public void setCiid(int ciid) {
        this.ciid = ciid;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }
}
