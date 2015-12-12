package edu.csumb.sarm6485.otterlibrarysystem;
/**
 * Title: Inventory.java
 * Abstract: This is the class for the ability to view all books in the inventory at the library.
 * Author: Michael Sarmiento
 * ID: 7101
 * Date: 12-11-2015
 */
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

public class Inventory extends Activity implements View.OnClickListener {

    // create a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);

        View mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        mainButton.bringToFront();

        TextView main = (TextView) findViewById(R.id.maininventory);

        ArrayList<Book> books = new ArrayList<>(db.getAllBooks());

        for(Book book: books){
            main.append(book.toString()+" \n");
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
        if (v.getId() == R.id.main_button) {
            Intent I = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(I);
        }


    }

}