package emef4z.gmail.com.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtcust_name,txtPhone,txtEmail;
    Button submit,viewcust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcust_name=(EditText) findViewById(R.id.customerName_editText);
        txtPhone=(EditText) findViewById(R.id.phone_number_editText);
        txtEmail=(EditText) findViewById(R.id.email_editText);
        submit = (Button) findViewById(R.id.reg_button);
        viewcust =(Button) findViewById(R.id.view_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerDB db = new CustomerDB(getBaseContext());
                String comm = db.AddCustomerDB(txtcust_name.getText().toString(),
                        txtPhone.getText().toString(),txtEmail.getText().toString());
                Toast.makeText(getBaseContext(),comm,Toast.LENGTH_LONG).show();



            }
        });

        viewcust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getBaseContext(),Customer_List.class);
                startActivity(myIntent);
            }
        });






    }




    /*Alternative Method */

   /* public void AddCustomer(View v) {

        CustomerDB db = new CustomerDB(getBaseContext());
        String comm = db.AddCustomerDB(txtcust_name.getText().toString(),
                txtPhone.getText().toString(),txtEmail.getText().toString());
        Toast.makeText(getBaseContext(),comm,Toast.LENGTH_LONG).show();

    }
    */





}
