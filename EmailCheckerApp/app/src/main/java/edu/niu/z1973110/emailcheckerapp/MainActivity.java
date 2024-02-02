/************************************************************************
 * *
 * CSCI 522 Assignment 4 Fall 2023
 * *
 * App Name: Assignment4 Part1
 * *
 * Class Name: MainActivity
 * *
 * Developer(s): Renuka Pasam
 * *
 * Due Date: 10/20/2023
 * *
 * Purpose: MainActivity.java class for the project
 * *
 ************************************************************************/
package edu.niu.z1973110.emailcheckerapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a LinearLayout as the main layout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setBackgroundColor(Color.WHITE);

        // Create EditText
        EditText emailEditText = new EditText(this);
        emailEditText.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        emailEditText.setHint("Enter Email");
        linearLayout.addView(emailEditText);

        // Create Button
        Button checkButton = new Button(this);
        checkButton.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        checkButton.setText("Check");
        linearLayout.addView(checkButton);

        // Create TextView
        TextView validationLabel = new TextView(this);
        validationLabel.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        validationLabel.setTextSize(24);
        validationLabel.setTypeface(null, android.graphics.Typeface.BOLD);
        validationLabel.setGravity(Gravity.CENTER);
        linearLayout.addView(validationLabel);

        // Set click listener for the button
        checkButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();

            if (email.contains("@") && email.indexOf("@") < email.lastIndexOf(".")) {
                validationLabel.setText("VALID");
                validationLabel.setTextColor(Color.GREEN);
            } else {
                validationLabel.setText("INVALID");
                validationLabel.setTextColor(Color.RED);
            }
        });

        // Set title
        setTitle("Email Validator");

        // Set content view to the created layout
        setContentView(linearLayout);
    }
}
