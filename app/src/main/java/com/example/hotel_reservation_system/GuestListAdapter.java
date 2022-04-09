package com.example.hotel_reservation_system;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.ViewHolder> {

    private List<GuestDetail> guestDetailList;
    private LayoutInflater layoutInflater;

    public GuestListAdapter(Context context, List<GuestDetail> guestDetailList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.guestDetailList = guestDetailList;
    }

    @NonNull
    @Override
    public GuestListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestListAdapter.ViewHolder holder, int position) {
        GuestDetail guestDetail = guestDetailList.get(position);
//        String guestName = guestDetail.getName();
//        String guestGender = guestDetail.getGender();

        // set up the text
//        holder.guestName.getText();
//        holder.guestName.setText(guestName);
//        holder.guestGender.setText(guestGender);

        // set data in list

        holder.guestName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                guestDetail.setName(holder.guestName.getText().toString());
            }
        });

        holder.guestGender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                guestDetail.setGender(holder.guestGender.getText().toString());
            }
        });
        System.out.println("+++++++++++++"+holder.guestName.getText().toString());
        guestDetail.setName(holder.guestName.getText().toString());
        guestDetail.setGender(holder.guestGender.getText().toString());
    }

    @Override
    public int getItemCount() {
        return guestDetailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        EditText guestName, guestGender;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            hotelName = itemView.findViewById(R.id.hotel_name_text_view);
//            hotelPrice = itemView.findViewById(R.id.price_text_view);
//            hotelAvailability = itemView.findViewById(R.id.availability_text_view);
            guestName = itemView.findViewById(R.id.guests_name_edit_text);
            guestGender = itemView.findViewById(R.id.guest_gender_edit_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("APP", "entered *************");
//            if (clickListener != null)
//                clickListener.onClick(view, getAbsoluteAdapterPosition());
        }
    }
}
