package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class BookingFragment extends Fragment {
    View view;
    TextView content;
    Button submitGuestDetailsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.booking_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        content = view.findViewById(R.id.booking_text_view);
        Button bookAgain = view.findViewById(R.id.booking_again);

        String hotelName = getArguments().getString("hotel name");
        String hotelPrice = getArguments().getString("hotel price");
        String numberOfGuests = getArguments().getString("number of guests");
        String bookingId = getArguments().getString("booking id");

        content.setText("Booking Confirmed. Confirmation ID : " + bookingId + " \nHotel Name : " + hotelName + "\nPrice : " + hotelPrice + "\nNumber of Guests : " + numberOfGuests);

        bookAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // set Fragment class Arguments
                HotelSearchFragment hotelSearchFragment = new HotelSearchFragment();
//                bookingFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_layout, hotelSearchFragment);
                fragmentTransaction.remove(BookingFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
