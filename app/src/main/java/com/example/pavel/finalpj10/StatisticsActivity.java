package com.example.pavel.finalpj10;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {
    TextView num,zv;
    DBHelper dbHelper;
    int check,check1,check2;
    ImageView imageView;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        check = 1;
        ImageView imageView = findViewById(R.id.Table);
        num = findViewById(R.id.textView6);
        zv = findViewById(R.id.textView7);
        dbHelper = new DBHelper(this);
        dbHelper = new DBHelper(getBaseContext());
        SQLiteDatabase db;
        db = dbHelper.getReadableDatabase();
        String SRAVNENIE = "SELECT * FROM " + DBHelper.TABLE_CONTACTS + ";";
        Cursor cursor1 = db.rawQuery(SRAVNENIE, null);
        cursor1.moveToFirst();
        check1 = cursor1.getCount();
        check2 = cursor1.getCount();
        String str = Integer.toString(check1);
        num.setText(str);

        if (check2 <= 15) {
            zv.setText("Ленивая панда.");
            imageView.setImageResource(R.drawable.panda1);
        }
        if (check2 >= 16 && check2<=30) {
            zv.setText("Панда, начинающая трудиться.");
            imageView.setImageResource(R.drawable.panda2);
        }
        if (check2 >= 31) {
            zv.setText("Панда - трудяга.");
            imageView.setImageResource(R.drawable.panda3);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                i = new Intent(StatisticsActivity.this, MainActivity.class );
                startActivity(i);
               StatisticsActivity.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

