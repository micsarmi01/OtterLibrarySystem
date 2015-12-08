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

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookResults extends Activity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookresults);

       //View LoginButton = findViewById(R.id.login_button);
        //LoginButton.setOnClickListener(this);

        System.out.println("Results: Passed info");

        //get passed info
        Bundle passedExtras = getIntent().getExtras();
        int rentalHours = passedExtras.getInt("rentalHours");
        int pickUpDayOfYear = passedExtras.getInt("pickUpDayOfYear");
        int dropOffDayOfYear= passedExtras.getInt("dropOffDayOfYear");
        String loggedUsername = passedExtras.getString("username");
        int loggedId = passedExtras.getInt("id");

        System.out.println("Passed: rentalHours" + rentalHours + " puDay: " + pickUpDayOfYear + " dropoff: "
                + dropOffDayOfYear + "user: " + loggedUsername + " id: " + loggedId);

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
