package com.example.hotel_reservation_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder> {

    private List<HotelListData> hotelListData;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    //Data gets passed in the constructor
    HotelListAdapter(Context context, List<HotelListData> hotelListData) {
        this.layoutInflater = LayoutInflater.from(context);
        this.hotelListData = hotelListData;
    }

    @NonNull
    @Override
    public HotelListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelListAdapter.ViewHolder holder, int position) {
        String hotelName = hotelListData.get(position).getName();
        String hotelPrice = hotelListData.get(position).getPrice();
        Double rating = hotelListData.get(position).getRating();
        hotelListData.get(position).setAvailability(true);
//        String hotelAvailability = hotelListData.get(position).getAvailability().toString();

        String photo_url_str = hotelListData.get(position).getUrl();
        System.out.println("****************" + photo_url_str);
//        URL newurl = null;
//        try {
//            newurl = new URL(photo_url_str);
//        } catch (MalformedURLException e) {
//            System.out.println("&&&&&&&&&&&&&&&&&&&&&");
//            e.printStackTrace();
//        }
//
//        Bitmap mIcon_val = null;
//        try {
//            mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
////            mIcon_val = mIcon_val;
//        } catch (IOException e) {
//            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//            e.printStackTrace();
//        }
        // set up the text
        holder.hotelName.setText(hotelName);
//        holder.hotelAvailability.setText(hotelAvailability);
        holder.hotelPrice.setText(hotelPrice);
        holder.rating.setText("Rating : " + rating.toString());
//        holder.hotelImage.setImageBitmap(mIcon_val);
        Picasso.get()
                .load(photo_url_str)
                .resize(0, 50)
                .centerCrop()
                .into(holder.hotelImage);
//        Picasso.get().load(photo_url_str).into(holder.hotelImage);
    }

    @Override
    public int getItemCount() {
        if (hotelListData != null) {
            return hotelListData.size();
        } else {
            return 0;
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView hotelName, hotelPrice, hotelAvailability, rating;
        ImageView hotelImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelName = itemView.findViewById(R.id.hotel_name_text_view);
            hotelPrice = itemView.findViewById(R.id.price_text_view);
//            hotelAvailability = itemView.findViewById(R.id.availability_text_view);
            rating = itemView.findViewById(R.id.rating_text_view);
            hotelImage = itemView.findViewById(R.id.hotel_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onClick(view, getAbsoluteAdapterPosition());
        }
    }

}