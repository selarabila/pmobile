package com.example.wuueeeenakkk;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Details extends AppCompatActivity {
    private PostService service;
    ListView list_post;
    List<Post> data;
    ArrayAdapter<Post> adapter;
    private ArrayList<String> mImageUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        data = new ArrayList<Post>();
        list_post = findViewById(R.id.list_post);
        adapter = new ArrayAdapter<Post>(this,android.R.layout.simple_list_item_1,data);

        list_post.setAdapter(adapter);

        service = APIClient.getClient().create(PostService.class);
        Call<List<Post>> call = service.getAllPost();
        ((retrofit2.Call)call).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.i("MYLOG", "DATA DARI SERVER: " +response.body());
                data = (List<Post>) response.body();
                adapter.addAll(data);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(Details.this,"Gagal ambil data", Toast.LENGTH_LONG).show();
            }
        });
        getIncomingIntent();
    }
    private void getIncomingIntent(){

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){


            String imageURL = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageURL, imageName);
        }
    }

    private void setImage(String imageURL, String imageName){

        TextView name = findViewById(R.id.textView4);
        name.setText(imageName);

        ImageView image = findViewById(R.id.imageView10);
        Glide.with(this)
                .asBitmap()
                .load(imageURL)
                .into(image);
    }
}
