package com.recycler.user.recycleriew;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.bumptech.glide.Glide;
import java.util.Random;

/**
 * Created by ruma on 14-12-2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private String[] mDataSet;
    private Context mContext;
    private Random mRandom = new Random();

    public CustomAdapter(Context context, String[] DataSet) {
        mDataSet = DataSet;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public ProgressBar progressBar;
        public LinearLayout mLinearLayout;

        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.img_iew);
           // progressBar = (ProgressBar) v.findViewById(R.id.progress);
        }
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new View
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        System.out.print("ImageUrl"+mDataSet[position]);
        Glide.with(mContext)
                .load(mDataSet[position])
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(holder.mImageView);
        /*holder.mTextView.setText(mDataSet[position]);
        // Generate a random color
        int color = getRandomHSVColor();

        // Set a random color for TextView background
        holder.mTextView.setBackgroundColor(getLighterColor(color));

        // Set a text color for TextView
        holder.mTextView.setTextColor(getReverseColor(color));

        // Set a gradient background for LinearLayout
        holder.mLinearLayout.setBackground(getGradientDrawable());

        // Emboss the TextView text
        applyEmbossMaskFilter(holder.mTextView);*/
    }

    @Override
    public int getItemCount() {
       // System.out.print("LenthCount~~~"+mDataSet.length);
        return mDataSet.length;
    }

}