package com.example.booksapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.booksapp.Books;
import com.example.booksapp.R;

import java.util.List;

public class BooksAdapter extends BaseAdapter {

    private List<Books> list;
    private LayoutInflater layoutInflater;

    public BooksAdapter(Context context, List<Books> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        }

        Books booksName = getBooksModel(position);
        TextView textView = (TextView)view.findViewById(R.id.title_book);
        textView.setText(booksName.getName());

        TextView textView2 = (TextView)view.findViewById(R.id.author_book);
        textView2.setText(booksName.getAuthor());

        TextView textView3 = (TextView)view.findViewById(R.id.genre_book);
        textView3.setText(booksName.getGenre());

        TextView textView4 = (TextView)view.findViewById(R.id.year_book);
        textView4.setText(String.valueOf(booksName.getYear()) + " год");

        return view;
    }

    private Books getBooksModel(int position){
        return (Books) getItem(position);
    }
}
