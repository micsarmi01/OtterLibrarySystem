package edu.csumb.sarm6485.otterlibrarysystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Log extends Activity implements View.OnClickListener {

    // create a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);

        TextView main = (TextView) findViewById(R.id.maininventory);

        ArrayList<Transaction> transactions = new ArrayList<>(db.getAllTransactions());

        for(Transaction transaction: transactions){
            main.append("Transaction Number: " + transaction.getId());
            main.append("\nUsername: " + transaction.getUsername());
            main.append("\nTransaction Type: " + transaction.getType());
            main.append("\nPick Up: " + transaction.getPickUpDate());
            main.append("\nReturn: " + transaction.getDropOffDate());
            main.append("\nTransaction Date: " + transaction.getDate());
            main.append("\nTransaction Time: " + transaction.getUsername());

        }

        db.getAllBooks();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {



    }

}