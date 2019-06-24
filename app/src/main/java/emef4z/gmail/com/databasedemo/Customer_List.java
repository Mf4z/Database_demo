package emef4z.gmail.com.databasedemo;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class Customer_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__list);

        ListView listView_Customers = (ListView) findViewById(R.id.list_view);

        try {

            CustomerDB db = new CustomerDB(getBaseContext());
            String[] columns = {"customer_name", "phone_no"};
            int[] txtIDs = {R.id.cusName,R.id.cusPhone};


            SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.test_customview,
                    db.getAllCustomers(), columns, txtIDs);


            listView_Customers.setAdapter(myAdapter);
        } catch(Exception ex)
        {
            Toast.makeText(getBaseContext(),"Error!!" + ex.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
}
