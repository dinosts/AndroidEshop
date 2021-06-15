package com.example.myeshop;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface theDao {
    @Insert
    public void addUser(User user); // vazei user

    @Insert
    public void addItem(Item item); // vazei Item

    @Insert
    public void addtocart(userCart usercart); // vazei item sto cart

    @Insert
    public void addTransaction(Transaction transaction); // vazei item transaction

    @Insert
    public void addMainTransaction(MainTransaction mainTransaction); // vazei Maintransaction

    @Update
    public void updateUser(User user); // Kanoun update...

    @Update
    public void updateItem(Item item);

    @Update
    public void updateCartItem(userCart userCart);

    @Update
    public void updateTransaction(MainTransaction mainTransaction);

    @Update
    public void updatetransactionItem(Transaction transaction);

    @Delete
    public void delUser(User user); // Kanoun Delete...

    @Delete
    public void delItem(Item item);

    @Delete
    public void delCart(userCart cartItem);

    @Delete
    public void delTrans(MainTransaction mainTransaction);

    @Query("select * from userCart where cuid=:uid") // psanxw to cart enos user kai to gyrnaw se lista
    public List<userCart> getCart(String uid);

    @Query("select * from Users") // gurnaw olous tou users
    public List<User> getUsers();

    @Query("select * from Users where uid=:id and pass=:pass") // psaxnw user me to id kai to pass tou kai gurnaw User object
    public User findUser(String id, String pass);

    @Query("select * from Users where uid=:id")// psaxnw user me to id  tou kai gurnaw User object
    public User findUser(String id);

    @Query("select * from items") // gurnaw ola ta items
    public List<Item> getItems();

    @Query("select * from items where itid=:id") // psaxnw item pou exei sigekrimeno id kai to gurnaw ws item obj
    public Item findItem(int id);

    @Query("select * from MainTransaction where tid=:id") // psaxnw Maintransaction me to id kai gurnaw Maintransaction obj
    public MainTransaction findMainTransaction(int id);

    @Query ("select * from userCart where ciid=:id") // psaxnw sigekrimeno item sto cart me id kai gurnaw usercart obj
    public userCart findItemInCart(int id);

    @Query("select * from transactions where mainid=:id")// pairnw ola ta item transaction enos Main transaction kai ta vriskw me to id tou kai gurnaw lista Transaction
    public List<Transaction> getTransactionItems(int id);

    @Query("select * from transactions where tiid=:id")// Psaxnw sigekrimeno item sta item transactions (Transaction) kai gurnaw thn lista me ola ta sales/transactions tou
    public List<Transaction> getTransactionItemSearch(int id);

    @Query("select * from MainTransaction")
    public List<MainTransaction> getMainTransactions(); // fernw ola ta Maintransactions

    @Query("select * from transactions where tid=:id")// fernw to transaction me to sigekrimeno id kai to gurnaw
    public Transaction findItemTransaction(int id);

    @Query("select count(*) from userCart where cuid=:uid") // gurnaw int ton arithmo ton items mesa sto cart kapoiou user
    public int getCartcount(String uid);

    @Query("select count(*) from MainTransaction") // gurnaw int ton arithmo olwn ton main transaction
    public int getMainTransactionCount();

    @Query("select Sum(iquant) from transactions where tiid=:id")// pr8eto ola ta quantity apo ena sigekrimeno item pou eginan transaction kai ta gurnaw se int
    public int getItemSales(int id);

}
