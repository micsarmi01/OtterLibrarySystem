package edu.csumb.sarm6485.otterlibrarysystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View CreateButton = findViewById(R.id.createaccount_button);
        CreateButton.setOnClickListener(this);

        View HoldButton = findViewById(R.id.placehold_button);
        HoldButton.setOnClickListener(this);

        View cancelButton = findViewById(R.id.cancelhold_button);
        cancelButton.setOnClickListener(this);


        View manageButton = findViewById(R.id.managesystem_button);
        manageButton.setOnClickListener(this);

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


        if (v.getId() == R.id.createaccount_button) {
            Intent I = new Intent(getApplicationContext(), CreateClass.class);
            startActivity(I);
        }
        else if (v.getId() == R.id.placehold_button) {
            Intent I = new Intent(getApplicationContext(),PlaceHold.class);
            startActivity(I);
        }
        else if (v.getId() == R.id.cancelhold_button) {
            Intent I = new Intent(getApplicationContext(),CancelHold.class);
            startActivity(I);
        }
        else if (v.getId() == R.id.managesystem_button) {
            Intent I = new Intent(getApplicationContext(),ManageSystem.class);
            startActivity(I);
        }

    }

}
