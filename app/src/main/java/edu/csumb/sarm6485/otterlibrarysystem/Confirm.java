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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Confirm extends Activity implements View.OnClickListener {

    // create a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);

        View test = findViewById(R.id.confirm_button);
        test.setOnClickListener(this);

        TextView main = (TextView) findViewById(R.id.main);

        Bundle passedExtras = getIntent().getExtras();
        int rentalHours = passedExtras.getInt("rentalHours");
        int pickUpDayOfYear = passedExtras.getInt("pickUpDayOfYear");
        int dropOffDayOfYear= passedExtras.getInt("dropOffDayOfYear");
        String pickUpYear= passedExtras.getString("pickUpYear");
        String dropOffYear = passedExtras.getString("dropOffYear");
        String loggedUsername = passedExtras.getString("username");
        int loggedId = passedExtras.getInt("id");
        String bookTitle = passedExtras.getString("title");
        double rentalTotal = passedExtras.getDouble("rentalTotal");

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        main.setText("");
        main.append("Book Title: " + bookTitle + " \n");
        main.append("Username: " + loggedUsername + " \n");
        main.append("Total Rental Cost: " + formatter.format(rentalTotal) + " \n");


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

        if (v.getId() == R.id.confirm_button) {

            Intent I = new Intent(getApplicationContext(), MainActivity.class);

            ArrayList<Book> books = new ArrayList<>(db.getAllBooks());

            Bundle passedExtras = getIntent().getExtras();
            int rentalHours = passedExtras.getInt("rentalHours");
            int pickUpDayOfYear = passedExtras.getInt("pickUpDayOfYear");
            int dropOffDayOfYear= passedExtras.getInt("dropOffDayOfYear");
            String pickUpYear= passedExtras.getString("pickUpYear");
            String dropOffYear = passedExtras.getString("dropOffYear");
            String loggedUsername = passedExtras.getString("username");
            int loggedId = passedExtras.getInt("id");
            String bookTitle = passedExtras.getString("title");
            double rentalTotal = passedExtras.getDouble("rentalTotal");

            //find the book in the array by title

            for(int i=0;i<books.size();i++){
                if(books.get(i).getTitle().equals(bookTitle)){
                    System.out.println("getAll This is the book by Title: " + books.get(i).getTitle());
                    String[] fifteen;

                    fifteen = books.get(i).getFifteen();

                    //alter the array
                    for (int j = pickUpDayOfYear; j < dropOffDayOfYear+1; j++) {

                        fifteen[j-1] = "1";
                        books.get(i).setFifteenString(fifteen);
                    }

                    db.updateBook(books.get(i));
                }
            }
            startActivity(I);
        }


    }



}