package com.example.mm.valleyrecyclerviewpicasso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.mm.valleyrecyclerviewpicasso.ExampleAdapter.EXTRA_CREATOR;
import static com.example.mm.valleyrecyclerviewpicasso.ExampleAdapter.EXTRA_LIKES;
import static com.example.mm.valleyrecyclerviewpicasso.ExampleAdapter.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialize the views
        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);

        Intent mIntent = getIntent();
        String imageUrl = mIntent.getStringExtra(EXTRA_URL);
        String creatorName = mIntent.getStringExtra(EXTRA_CREATOR);
        int likeCount = mIntent.getIntExtra(EXTRA_LIKES, 0);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(creatorName);
        textViewLikes.setText("Likes: " + likeCount);

    }
}
