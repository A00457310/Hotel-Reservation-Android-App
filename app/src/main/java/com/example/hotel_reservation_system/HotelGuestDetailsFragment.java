package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelGuestDetailsFragment extends Fragment {

    View view;
    List<GuestDetail> guestDetailList = new ArrayList<>();
    String hotelName, hotelPrice, hotelAvailability, hotelId;
    Integer numberOfGuests;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_guest_details_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView hotelRecapTextView = view.findViewById(R.id.hotel_recap_text_view);
        Button submitGuestDetailsButton = view.findViewById(R.id.submit_guest_detail_list_button);

        hotelName = getArguments().getString("hotel name");
        hotelPrice = getArguments().getString("hotel price");
        hotelId = getArguments().getString("hotel id");
        hotelAvailability = getArguments().getString("hotel availability");
        numberOfGuests = Integer.valueOf(getArguments().getString("number of guests"));


        hotelRecapTextView.setText("You have selected " + hotelName + ". The cost will be $ " + hotelPrice + " and availability is " + hotelAvailability);

        for (int i = 0; i < numberOfGuests; i++) {
            guestDetailList.add(new GuestDetail());
        }

        setupRecyclerView();


        submitGuestDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("MYAPP" + guestDetailList.get(0).getName());
//                Log.d("MYAPP", guestDetailList.get(0).getName());
                Log.d("MYAPP", "-----------------");
                System.out.println("MYAPP     -----------------");
                Log.d("MYAPP -> ", String.valueOf(guestDetailList.size()));

                for (int i = 0; i < guestDetailList.size(); i++) {
                    System.out.println("^^^^^^^^" + guestDetailList.get(i).getName());
                }

                ReserveRoomRequestBody body = getReserveRoomRequestBody();

                reserveRoom(body);
            }
        });

    }

    @NonNull
    private ReserveRoomRequestBody getReserveRoomRequestBody() {
        ReserveRoomRequestBody body = new ReserveRoomRequestBody();
        body.setCheckInDate("2022-03-12T01:08:48.470Z");
        body.setCheckOutDate("2022-03-12T01:08:48.470Z");
        body.setGuests(guestDetailList);
        body.setUserId(20);
        body.setHotelId(Integer.parseInt(hotelId));
        body.setNoOfRoomsBooked(numberOfGuests);
        return body;
    }

    private void reserveRoom(ReserveRoomRequestBody body) {
        System.out.println("&&&&&&&&&&&&&&&&&&&");
        Api.getClient().reserveRoom(body, new Callback<ReserveRoomApiResponse>() {
            @Override
            public void success(ReserveRoomApiResponse reserveRoomApiResponse, Response response) {
                Log.d("MyApp", "I am here");
                Log.d("MyApp", "^^^^^^^^^^^^^^^^^^^^ -> " + reserveRoomApiResponse.getMessage());
                System.out.println("^^^^^^^^^^^^^^^^^^^^ -> " + reserveRoomApiResponse.getData().getConfirmationId());
//                Toast.makeText(getActivity(), "Booking Confirmed : " + reserveRoomApiResponse.getData().getConfirmationId(), Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putString("hotel name", hotelName);
                bundle.putString("hotel price", hotelPrice);
                bundle.putString("number of guests", String.valueOf(numberOfGuests));
//                bundle.putString("guest name", guestName);
                bundle.putString("booking id", reserveRoomApiResponse.getData().getConfirmationId());


                // set Fragment class Arguments
                BookingFragment bookingFragment = new BookingFragment();
                bookingFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_layout, bookingFragment);
                fragmentTransaction.remove(HotelGuestDetailsFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });

//        Api.getClient().getHotelsLists(new Callback<GetHotelResponse>() {
//
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void success(GetHotelResponse userListResponse, Response response) {
//                // in this method we will get the response from API
////                System.out.println(userListResponses.);
//                Log.d("MyApp","I am here");
//                Log.d("MyApp", "^^^^^^^^^^^^^^^^^^^^ -> " + userListResponse.getMessage());
//                System.out.println("^^^^^^^^^^^^^^^^^^^^ -> " + userListResponse.getMessage());
////                userListResponses.stream().forEach(hotelListData -> System.out.println(hotelListData.getName() + "^^^^^^^^^^" + hotelListData.getRating().toString()));
//                userListResponseData = userListResponse.getData();
//
//
//                // Set up the RecyclerView
//                setupRecyclerView();
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                // if error occurs in network transaction then we can get the error in this method.
//                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
//            }
//        });
    }

    private void setupRecyclerView() {
//        progressBar.setVisibility(View.GONE);
        RecyclerView recyclerView = view.findViewById(R.id.guest_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        GuestListAdapter guestListAdapter = new GuestListAdapter(getActivity(), guestDetailList);
//        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), userListResponseData);
        recyclerView.setAdapter(guestListAdapter);

        //Bind the click listener
//        hotelListAdapter.setClickListener(this);
    }
}
