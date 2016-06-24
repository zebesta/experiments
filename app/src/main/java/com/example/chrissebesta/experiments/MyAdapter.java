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

    public interface OnItemClickListener {
        void onItemClick(PlantData plantData);
    }
    //private String[] mDataset;
    private final ArrayList<PlantData> mDataset;
    private Context mContext;
    private int mScreenWidth;
    private int mScreenHeight;
    private final OnItemClickListener mListener;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public ImageView mImageViewForCard;
        public TextView mNameTextViewInCard;
        //public TextView mDescriptionTextViewInCard;
        public TextView mSunTextViewInCard;

        public ViewHolder(View v) {
            super(v);
            mCardView = (CardView) v;
            mNameTextViewInCard = (TextView) v.findViewById(R.id.card_text_view_for_name);
            //mDescriptionTextViewInCard = (TextView) v.findViewById(R.id.card_text_view_for_description);
            mSunTextViewInCard = (TextView) v.findViewById(R.id.card_text_view_for_optimal_sun);
            mImageViewForCard = (ImageView) v.findViewById(R.id.card_image);

        }
        public void bind(final PlantData item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    //public MyAdapter(String[] myDataset) {
    public MyAdapter(ArrayList<PlantData> myDataset, Context context, OnItemClickListener listener) {
        mContext = context;
        mDataset = myDataset;
        mListener = listener;
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
//        holder.mDescriptionTextViewInCard.setText(mDataset.get(position).getDescription());
        holder.mSunTextViewInCard.setText(mDataset.get(position).getOptimal_sun());
        holder.bind(mDataset.get(position), mListener);
        int cardWidth = holder.mCardView.getWidth();
        Picasso.with(mContext)
                .load(mDataset.get(position).getImage())
                .resize(Math.min(mScreenWidth, mScreenHeight), Math.min(mScreenWidth / 2, mScreenHeight / 2))
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
