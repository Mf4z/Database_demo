package emef4z.gmail.com.databasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by USER on 06-Oct-16.
 */

public class CustomerDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =2;
    public static final String DATABASE_NAME ="customer_db.db";
    public static final String CREATE__CUSTOMER = "CREATE TABLE customer(_id INT PRIMARY KEY ,"
            +"customer_name TEXT,phone_no TEXT,email TEXT);";

    public static final String REMOVE__CUSTOMER = "DROP TABLE customer;";



    public CustomerDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE__CUSTOMER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(REMOVE__CUSTOMER);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db,oldVersion,newVersion);
        db.execSQL(REMOVE__CUSTOMER);
        onCreate(db);
    }


    public String AddCustomerDB(String cust_name,String phone,String email)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        try{
            String INSERT_SQL = "INSERT INTO customer(customer_name,phone_no,email)"+
                    "VALUES('"+cust_name+"','"+phone+"','"+email+"')";
            db.execSQL(INSERT_SQL);

            return "Customer Inserted Successfully";
        } catch (Exception ex)
        {
            return "Error!! "+ ex.getMessage();
        }
    }

    public Cursor getAllCustomers()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String SELECT_SQL = "SELECT * FROM customer;";
        return  db.rawQuery(SELECT_SQL,null);
    }
}
