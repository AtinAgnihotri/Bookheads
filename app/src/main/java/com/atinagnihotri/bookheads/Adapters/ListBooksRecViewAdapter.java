package com.atinagnihotri.bookheads.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

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
        setBookTxtInfo(holder, position);
        loadBookImage(holder, position);
        manageBookExpandedView(holder, position);

        holder.bookListItemParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, books.get(position).getName() + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void manageBookExpandedView(@NonNull ViewHolder holder, int position) {
        if (books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.bookListItemParent);
            holder.bookListItemExpanded.setVisibility(View.VISIBLE);
            holder.imgBtnBookItemDownArrow.setVisibility(View.GONE);
        } else {
            TransitionManager.beginDelayedTransition(holder.bookListItemParent);
            holder.bookListItemExpanded.setVisibility(View.GONE);
            holder.imgBtnBookItemDownArrow.setVisibility(View.VISIBLE);
        }
    }

    private void loadBookImage(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .centerCrop()
                .into(holder.imgBookItem);
    }

    private void setBookTxtInfo(@NonNull ViewHolder holder, int position) {
        holder.txtBookItemName.setText(books.get(position).getName());
        holder.txtBookItemAuthor.setText(books.get(position).getAuthor());
        holder.txtBookItemShortDesc.setText(books.get(position).getShortDesc());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView bookListItemParent;
        private ImageView imgBookItem;
        private ImageView imgBtnBookItemDownArrow;
        private ImageView imgBtnBookItemUpArrow;
        private TextView txtBookItemName;
        private TextView txtBookItemAuthor;
        private TextView txtBookItemShortDesc;
        private RelativeLayout bookListItemExpanded;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
            setImageButtonOnClickListeners();
        }

        private void initViews(@NonNull View itemView){
            bookListItemParent = itemView.findViewById(R.id.bookListItemParent);
            imgBookItem = itemView.findViewById(R.id.imgBookItem);
            txtBookItemName = itemView.findViewById(R.id.txtBookItemName);
            imgBtnBookItemDownArrow = itemView.findViewById(R.id.imgBtnBookItemDownArrow);
            imgBtnBookItemUpArrow = itemView.findViewById(R.id.imgBtnBookItemUpArrow);
            txtBookItemAuthor = itemView.findViewById(R.id.txtBookItemAuthor);
            txtBookItemShortDesc = itemView.findViewById(R.id.txtBookItemShortDesc);
            bookListItemExpanded = itemView.findViewById(R.id.bookListItemExpanded);
        }

        private void setImageButtonOnClickListeners(){
            setOnClickListenerToChangeBookExpanded(imgBtnBookItemDownArrow);
            setOnClickListenerToChangeBookExpanded(imgBtnBookItemUpArrow);
        }

        private void setOnClickListenerToChangeBookExpanded(View view) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BookDTO book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }


    }
}
