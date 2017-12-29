package com.recycler.user.recycleriew;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager  mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request window feature action bar
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();

        // Change the action bar color
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#FF677589"))
        );

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Initialize a new String array
        String[] imageUrl = {"http://s8.postimg.org/r4i9hvbj9/image5.png",
                "http://s17.postimg.org/s5o6xxnsf/image6.png",
                "http://s7.postimg.org/ld0nmfcyz/image10.png",
                "http://s8.postimg.org/r4i9hvbj9/image5.png",
                "http://s17.postimg.org/s5o6xxnsf/image6.png",
                "http://s7.postimg.org/ld0nmfcyz/image10.png",
                "http://s8.postimg.org/r4i9hvbj9/image5.png",
                "http://s17.postimg.org/s5o6xxnsf/image6.png",
                "http://s7.postimg.org/ld0nmfcyz/image10.png",
                "http://s17.postimg.org/s5o6xxnsf/image6.png",
        };


        // Define a layout for RecyclerView
        mLayoutManager = new GridLayoutManager(mContext,4);

        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position==0){
                    return 4;
                }else if(position==1){
                    return  2;
                }else if(position==2){
                    return 1;
                }else {
                    return 1;
                }


            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new CustomAdapter(mContext,imageUrl);

        // Set the adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }



}
