package com.example.myeshop;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "users")
public class User {                                         // O USER

    public User(String id,String pass,String name,String address,boolean admin)
    {
        this.id=id;
        this.pass=pass;
        this.name=name;
        this.address=address;
        this.admin=admin;
    }

    @PrimaryKey @ColumnInfo (name = "uid") @NonNull
    private String id;                                  // TO ID
    @ColumnInfo(name = "pass") @NonNull
    private String pass;                                // TO PASS
    @ColumnInfo (name = "name") @NonNull
    private String name;                                // TO FULL NAME
    @ColumnInfo (name = "address") @NonNull
    private String address;                             // TO ADDRESS
    @ColumnInfo (name = "admin") @NonNull
    private boolean admin;                              //

    public boolean isAdmin() { return admin; }

    public void setAdmin(boolean admin) { this.admin = admin; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
