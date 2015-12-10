package edu.csumb.sarm6485.otterlibrarysystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;



public class CancelHold extends Activity implements View.OnClickListener {

    // create a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelhold);

        View cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(this);

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

        int bookToCancel = 1;
        int pickUpDay = 340;
        int dropDay = 364;


        if (v.getId() == R.id.cancel) {

            ArrayList<Book> books = new ArrayList<>(db.getAllBooks());

            for(int i=0; i<books.size();i++){
                if(books.get(i).getId()==bookToCancel){
                    String[] fifteen;
                    fifteen = books.get(i).getFifteen();

                    System.out.println("Canceling This Title: " + books.get(i).getTitle());
                    for(int j=pickUpDay; j<dropDay+1;j++){
                        fifteen[j] = "0";
                    }

                    books.get(i).setFifteen(fifteen);
                    books.get(i).setFifteenString(fifteen);

                    db.updateBook(books.get(i));
                }
            }


        }

    }

}