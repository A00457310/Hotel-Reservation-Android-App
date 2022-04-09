package com.example.hotel_reservation_system;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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

        holder.guestEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                guestDetail.setGender(holder.guestEmail.getText().toString());
            }
        });
        System.out.println("+++++++++++++"+holder.guestName.getText().toString());
        guestDetail.setName(holder.guestName.getText().toString());
        guestDetail.setGender(holder.guestEmail.getText().toString());
    }

    @Override
    public int getItemCount() {
        return guestDetailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        EditText guestName, guestEmail;
        Spinner genderSpinner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guestName = itemView.findViewById(R.id.guests_name_edit_text);
            guestEmail = itemView.findViewById(R.id.guest_email_edit_text);
            //get the spinner from the xml.
            genderSpinner = itemView.findViewById(R.id.gender_spinner);

            //create a list of items for the spinner.
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(itemView.getContext(),
                    R.array.gender, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            genderSpinner.setAdapter(adapter);
        }

        @Override
        public void onClick(View view) {
            Log.d("APP", "entered *************");
//            if (clickListener != null)
//                clickListener.onClick(view, getAbsoluteAdapterPosition());
        }
    }
}
