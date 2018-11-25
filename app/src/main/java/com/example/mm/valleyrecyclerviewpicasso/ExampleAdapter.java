package com.example.mm.valleyrecyclerviewpicasso;

import android.content .Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    public static final String EXTRA_URL = "imageUrl";

    public static final String EXTRA_CREATOR = "creatorName";

    public static final String EXTRA_LIKES = "likeCount";

    private Context mContext;

    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        holder.mTextViewCreator.setText(currentItem.getCreator());
        holder.mTextViewLikes.setText("Likes: " + currentItem.getLikeCount());
        Picasso.with(mContext).load(currentItem.getImageUrl()).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mImageView;
        private TextView mTextViewCreator;
        private TextView mTextViewLikes;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ExampleItem item = mExampleList.get(getAdapterPosition());
            Intent mIntent = new Intent(mContext, DetailActivity.class);

            mIntent.putExtra(EXTRA_URL, item.getImageUrl());
            mIntent.putExtra(EXTRA_CREATOR, item.getCreator());
            mIntent.putExtra(EXTRA_LIKES, item.getLikeCount());

            mContext.startActivity(mIntent);
        }
    }
}
