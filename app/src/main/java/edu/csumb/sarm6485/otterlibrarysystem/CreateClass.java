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

public class CreateClass extends Activity implements View.OnClickListener {

    // create a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);

        View CreateButton = findViewById(R.id.createaccount_button);
        CreateButton.setOnClickListener(this);

        //System.out.println("Checking Username: " + checkFormat("mike$!"));



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

    String input1;
    String input2;
    EditText cinput1;
    EditText cinput2;

    public void onClick(View v) {
        cinput1 = (EditText) findViewById(R.id.username_field);
        input1 = cinput1.getText().toString();

        cinput2 = (EditText) findViewById(R.id.password_field);
        input2 = cinput2.getText().toString();

        if (v.getId() == R.id.createaccount_button) {

            if(checkFormat(input1)&&checkFormat(input2)) {

                User user = new User(input1, input2);
                db.addUser(user);

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Successfully Created Account");
                dlgAlert.setTitle("Otter Library System");
                dlgAlert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(I);
                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                System.out.println(db.getAllUsers());
            }
            else{
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Your Username or Password are not correctly formatted! Please Retry!");
                dlgAlert.setTitle("Otter Library System");
                dlgAlert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        }

    }

    public boolean checkFormat(String username){

        ArrayList<Character> charList = new ArrayList<Character>();
        Collections.addAll(charList, '!', '$', '#', '@');

        boolean containsSpecial = false;

        for(Character character: charList) {
            if (username.contains(Character.toString(character))) {
                containsSpecial = true;
            }
        }

        int numberCharacters = 0;

        if(containsSpecial){
            for(int i=0; i<username.length();i++){
                String symbol = String.valueOf(username.charAt(i));

                Pattern pattern = Pattern.compile("[A-z]");

                Matcher matcher = pattern.matcher(symbol);

                if(matcher.matches()){
                    numberCharacters++;
                    System.out.println("Match: " + numberCharacters);
                }
            }
        }

        if(numberCharacters>2){
            return true;
        }
        else {
            return false;
        }
    }

}
