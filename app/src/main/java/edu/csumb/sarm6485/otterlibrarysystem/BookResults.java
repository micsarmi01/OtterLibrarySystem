package edu.csumb.sarm6485.otterlibrarysystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookResults extends Activity implements View.OnClickListener {
    // create a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookresults);

        View test = findViewById(R.id.test);
        test.setOnClickListener(this);

        System.out.println("Results: Passed info");

        //add passed year
        //get passed info
        Bundle passedExtras = getIntent().getExtras();
        int rentalHours = passedExtras.getInt("rentalHours");
        int pickUpDayOfYear = passedExtras.getInt("pickUpDayOfYear");
        int dropOffDayOfYear= passedExtras.getInt("dropOffDayOfYear");
        String loggedUsername = passedExtras.getString("username");
        int loggedId = passedExtras.getInt("id");
        String pickUpYear = passedExtras.getString("pickUpYear");
        String dropOffYear = passedExtras.getString("dropOffYear");

        System.out.println("Passed - rentalHours: " + rentalHours + " puDay: " + pickUpDayOfYear +
                "Pick Up Year: " + pickUpYear + " dropoff day: " + dropOffDayOfYear +
                "Drop Year: " + dropOffYear + "user: " + loggedUsername + " id: " + loggedId);


        //Get all books that have the dates free
        //Between
        ArrayList<Book> books = new ArrayList<>(db.getAllBooks());
        ArrayList<Book> availableBooks = new ArrayList<>();

        System.out.println("getAll size:" + books.size());


        for(Book book: books) {
            boolean bookAvaialble = true;

            String[] fifteen = new String[book.getFifteen().length];
            fifteen = book.getFifteen();

            System.out.println("getAll index: " + fifteen[0]);

            for (int i = pickUpDayOfYear; i < dropOffDayOfYear; i++) {

                if(fifteen[i].equals("1")){
                    System.out.println("getAll has one");
                    bookAvaialble = false;
                    break;
                }
            }

            if(bookAvaialble){
                availableBooks.add(new Book(book));
            }

        }

        TextView main = (TextView) findViewById(R.id.main);

        System.out.print("getAll available books: " + availableBooks.size());
        for(int i =0; i<availableBooks.size();i++){
            System.out.print("Title: " + availableBooks.get(i).getTitle() + " ");
            main.append("Title: " + availableBooks.get(i).getTitle() + " ");
            System.out.println(books.get(i).toString());
        }






        System.out.println("");

        //choose the book you want to change the date for

        //user chooses book
        //book and dates are passed to Reserve
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

        if (v.getId() == R.id.test){

            Intent I = new Intent(getApplicationContext(), Confirm.class);

            //get passed info
            Bundle passedExtras = getIntent().getExtras();
            int rentalHours = passedExtras.getInt("rentalHours");
            int pickUpDayOfYear = passedExtras.getInt("pickUpDayOfYear");
            int dropOffDayOfYear= passedExtras.getInt("dropOffDayOfYear");
            String pickUpYear= passedExtras.getString("pickUpYear");
            String dropOffYear = passedExtras.getString("dropOffYear");
            String loggedUsername = passedExtras.getString("username");
            int loggedId = passedExtras.getInt("id");

            //pass stuff to results
            Bundle extraInfo = new Bundle();
            extraInfo.putInt("rentalHours", rentalHours);
            extraInfo.putInt("pickUpDayOfYear", pickUpDayOfYear);
            extraInfo.putInt("dropOffDayOfYear", dropOffDayOfYear);
            extraInfo.putString("pickUpYear", pickUpYear);
            extraInfo.putString("dropOffYear", dropOffYear);
            extraInfo.putString("username", loggedUsername );
            extraInfo.putInt("id", loggedId);
            extraInfo.putInt("bookId", 1);
            I.putExtras(extraInfo);

            startActivity(I);
        }

    }


}
