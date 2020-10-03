package com.atinagnihotri.bookheads.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.atinagnihotri.bookheads.DTO.BookDTO;
import com.atinagnihotri.bookheads.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListBooksRecViewAdapter extends RecyclerView.Adapter<ListBooksRecViewAdapter.ViewHolder> {

    private static final String TAG = "ListBooksRecViewAdapter";
    private ArrayList<BookDTO> books = new ArrayList<>();
    private Context mContext;

    public ListBooksRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBooks(ArrayList<BookDTO> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtBookItemName.setText(books.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .centerCrop()
                .into(holder.imgBookItem);
        holder.bookListItemParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, books.get(position).getName() + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView bookListItemParent;
        private ImageView imgBookItem;
        private TextView txtBookItemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(@NonNull View itemView){
            bookListItemParent = itemView.findViewById(R.id.bookListItemParent);
            imgBookItem = itemView.findViewById(R.id.imgBookItem);
            txtBookItemName = itemView.findViewById(R.id.txtBookItemName);
        }
    }
}
