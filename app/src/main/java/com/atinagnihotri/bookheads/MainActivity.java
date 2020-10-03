package com.atinagnihotri.bookheads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.atinagnihotri.bookheads.GlobalUtils.GlobalUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btnListAllBooks;
    private Button btnBooksCurrReading;
    private Button btnListBooksRead;
    private Button btnAbout;
    private Button btnFavBooks;
    private Button btnWishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setButtonOnClickListeners();
    }

    /**
     * Initialise all the views on the activity
     */
    private void initViews(){
        Log.d(TAG, "initViews : Views Initialisation started");
        // Init all views
        btnListAllBooks = findViewById(R.id.btnListAllBooks);
        btnBooksCurrReading = findViewById(R.id.btnBooksCurrReading);
        btnListBooksRead = findViewById(R.id.btnListBooksRead);
        btnAbout = findViewById(R.id.btnAbout);
        btnFavBooks = findViewById(R.id.btnFavBooks);
        btnWishList = findViewById(R.id.btnWishList);
        Log.d(TAG, "initViews : Buttons Initialised");
    }

    private void setButtonOnClickListeners(){
        btnListAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This intent will navigate us from the context of this activity to the AllBooksActivity
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }
}