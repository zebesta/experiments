package com.example.chrissebesta.experiments;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by chrissebesta on 6/23/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    //private String[] mDataset;
    private ArrayList<PlantData> mDataset;
    private Context mContext;
    private int mScreenWidth;
    private int mScreenHeight;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public ImageView mImageViewForCard;
        public TextView mNameTextViewInCard;
        public TextView mDescriptionTextViewInCard;
        public TextView mSunTextViewInCard;

        public ViewHolder(View v) {
            super(v);
            mCardView = (CardView) v;
            mNameTextViewInCard = (TextView) v.findViewById(R.id.card_text_view_for_name);
            mDescriptionTextViewInCard = (TextView) v.findViewById(R.id.card_text_view_for_description);
            mSunTextViewInCard = (TextView) v.findViewById(R.id.card_text_view_for_optimal_sun);
            mImageViewForCard = (ImageView) v.findViewById(R.id.card_image);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    //public MyAdapter(String[] myDataset) {
    public MyAdapter(ArrayList<PlantData> myDataset, Context context) {
        mContext = context;
        mDataset = myDataset;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mScreenWidth = size.x;
        mScreenHeight = size.y;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mNameTextViewInCard.setText(mDataset.get(position).getName());
        holder.mDescriptionTextViewInCard.setText(mDataset.get(position).getDescription());
        holder.mSunTextViewInCard.setText(mDataset.get(position).getOptimal_sun());
        Picasso.with(mContext)
                .load(mDataset.get(position).getImage())
                .resize(mScreenWidth/2, mScreenWidth/4)
                .centerCrop()
                .into(holder.mImageViewForCard);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //return mDataset.length;
        return mDataset.size();
    }
}
