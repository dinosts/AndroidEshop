package com.example.myeshop;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "MainTransaction",              //MAINTRANSACTION opou einai to vasiko transaction pou periexei item transactions
        primaryKeys={"tid"},
        foreignKeys= {
                @ForeignKey(entity = User.class,
                        parentColumns = "uid",
                        childColumns = "tuid",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        })
public class MainTransaction {
    @ColumnInfo(name = "tid") @NonNull
    private int id;                         //TO ID
    @ColumnInfo (name = "tuid") @NonNull
    private String tuid;                    //TO USER ID
    @ColumnInfo (name = "Date") @NonNull
    private String tdate;                   // TO DATE


    public MainTransaction(int id, String tuid, String tdate) {
        this.id = id;
        this.tuid = tuid;
        this.tdate = tdate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTuid() {
        return tuid;
    }

    public void setTuid(String tuid) {
        this.tuid = tuid;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String date) {
        this.tdate = date;
    }

}

