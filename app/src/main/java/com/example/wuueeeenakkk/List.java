package com.example.wuueeeenakkk;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.d(TAG, "onCreate: started");

        initImageBitmap();
    }
    private void initImageBitmap(){
        Log.d(TAG, "initImageBitmap: preparing bitmap");
        mImageUrls.add("https://parade.com/wp-content/uploads/2019/10/Pumpkin-Pie-Cheesecake-Slice-FTR-1024x640.jpg");
        mNames.add("Pecan Pie Cheesecake");
        mImageUrls.add("https://food.fnr.sndimg.com/content/dam/images/food/fullset/2006/10/9/0/bh0204_passionberry1.jpg.rend.hgtvcom.826.620.suffix/1371584130151.jpeg");
        mNames.add("Passionberry Dessert");
        mImageUrls.add("https://spicysouthernkitchen.com/wp-content/uploads/peanut-butter-pizza-3.jpg");
        mNames.add("Peanut Butter Cup Dessert Pizza");
        mImageUrls.add("https://irepo.primecp.com/2019/10/426575/Cold-Fudge-Cake-updated_Large400_ID-3414547.jpg?v=3414547");
        mNames.add("Cold Fudge Cake");
        mImageUrls.add("https://irepo.primecp.com/2017/05/330046/Chocolate-Dessert-Lasagna_ArticleImage-CategoryPage_ID-2227443.jpg?v=2227443");
        mNames.add("Chocolate Dessert Lasagna");
        mImageUrls.add("https://www.forkknifeswoon.com/wp-content/uploads/2015/02/20150213-Fork_Knife_Swoon_Vegan_Vanilla_Chia_Pudding_Raspberry_Rhubarb_Compote_01b.jpg");
        mNames.add("Dreamy Creamy Pudding");
        mImageUrls.add("https://irepo.primecp.com/2015/06/225272/New-York-Cheesecake_ArticleImage-CategoryPage_ID-1053091.jpg?v=1053091");
        mNames.add("New York Cheesecake");
        mImageUrls.add("https://irepo.primecp.com/2016/02/253752/No-Bake-Cheesecake_ArticleImage-CategoryPage_ID-1395339.jpg?v=1395339");
        mNames.add("No-Bake Cheesecake");
        mImageUrls.add("https://irepo.primecp.com/2018/07/379840/Easy-Blueberry-Swirl-Cheesecake_ArticleImage-CategoryPage_ID-2828275.jpg?v=2828275");
        mNames.add("Easy Blueberry Swirl Cheesecake");
        mImageUrls.add("https://irepo.primecp.com/2016/07/291784/Chocolate-Mousse-Cups_ArticleImage-CategoryPage_ID-1781133.jpg?v=1781133");
        mNames.add("Chocolate Mousse Cups");
        mImageUrls.add("https://irepo.primecp.com/2015/06/222107/Black-and-White-Napoleon-Pudding_ArticleImage-CategoryPage_ID-1015119.jpg?v=1015119");
        mNames.add("Black and White Napoleon Pudding");


        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init RecyclerView");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(this,mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
