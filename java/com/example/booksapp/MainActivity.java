package com.example.booksapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    List<Books> list = new ArrayList<Books>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list1);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,initData());
        BooksAdapter adapter = new BooksAdapter(this, list);
        listView.setAdapter(adapter);

    }

    public void onButtinClick(View v) {
        EditText book_name = (EditText)findViewById(R.id.editName);

        EditText book_author = (EditText)findViewById(R.id.editAuthor);
        EditText book_year = (EditText)findViewById(R.id.editYear);
        EditText book_genre = (EditText)findViewById(R.id.editGenre);
        list.add(new Books(book_name.getText().toString(), book_author.getText().toString(), Integer.parseInt(book_year.getText().toString()), book_genre.getText().toString()));

        ListView list1 = (ListView)findViewById(R.id.list1);
        list1.invalidateViews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.about:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.close:
                this.finishAffinity();
                break;
        }
        return true;

    }
}