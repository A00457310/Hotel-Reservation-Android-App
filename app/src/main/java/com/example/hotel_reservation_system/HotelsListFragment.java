package com.example.hotel_reservation_system;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelsListFragment extends Fragment implements ItemClickListener {

    View view;
    TextView headingTextView;
    ProgressBar progressBar;
    List<HotelListData> userListResponseData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_list_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //heading text view
        headingTextView = view.findViewById(R.id.heading_text_view);
        progressBar = view.findViewById(R.id.progress_bar);

        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String numberOfGuests = getArguments().getString("number of guests");
        String guestName = getArguments().getString("guest name");

        //Set up the header
        headingTextView.setText("Welcome " + guestName + ", \nDisplaying hotel for " + numberOfGuests + " guests staying from " + checkInDate +
                " to " + checkOutDate);


        // Set up the RecyclerView
//        ArrayList<HotelListData> hotelListData = initHotelListData();
//        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), hotelListData);
//        recyclerView.setAdapter(hotelListAdapter);
        getHotelsListsData();
    }

    public ArrayList<HotelListData> initHotelListData() {
        ArrayList<HotelListData> list = new ArrayList<>();
        list.add(new HotelListData("Halifax Regional Hotel", 100, "2000$", 4.3, true));
        list.add(new HotelListData("Hotel Pearl", 200, "500$", 4.1, false));
        list.add(new HotelListData("Hotel Amano", 210, "800$", 3.8, true));
        list.add(new HotelListData("San Jones", 300, "250$", 4.0, false));
        list.add(new HotelListData("Halifax Regional Hotel", 400, "2000$", 2.7, true));
        list.add(new HotelListData("Hotel Pearl", 700, "500$", 4.4, false));
        list.add(new HotelListData("Hotel Amano", 30, "800$", 3.7, true));
        list.add(new HotelListData("San Jones", 70, "250$", 3.5, false));

        return list;
    }

    private void getHotelsListsData() {
        progressBar.setVisibility(View.VISIBLE);
        System.out.println("&&&&&&&&&&&&&&&&&&&");
        Api.getClient().getHotelsLists(new Callback<GetHotelResponse>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void success(GetHotelResponse userListResponse, Response response) {
                // in this method we will get the response from API
//                System.out.println(userListResponses.);
                Log.d("MyApp", "I am here");
                Log.d("MyApp", "^^^^^^^^^^^^^^^^^^^^ -> " + userListResponse.getMessage());
                System.out.println("^^^^^^^^^^^^^^^^^^^^ -> " + userListResponse.getMessage());
//                userListResponses.stream().forEach(hotelListData -> System.out.println(hotelListData.getName() + "^^^^^^^^^^" + hotelListData.getRating().toString()));
                userListResponseData = userListResponse.getData();


                // Set up the RecyclerView
                setupRecyclerView();
            }

            @Override
            public void failure(RetrofitError error) {
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRecyclerView() {
        progressBar.setVisibility(View.GONE);
        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), userListResponseData);
        recyclerView.setAdapter(hotelListAdapter);

        //Bind the click listener
        hotelListAdapter.setClickListener(this);
    }


    @Override
    public void onClick(View view, int position) {
        HotelListData hotelListData = userListResponseData.get(position);

        String hotelName = hotelListData.getName();
        String price = hotelListData.getPrice();
        String availability = hotelListData.getAvailability().toString();

        Bundle bundle = new Bundle();
        bundle.putString("hotel name", hotelName);
        bundle.putString("hotel id", hotelListData.getId().toString());
        bundle.putString("hotel price", price);
        bundle.putString("hotel availability", availability);
        bundle.putString("number of guests", getArguments().getString("number of guests"));

        HotelGuestDetailsFragment hotelGuestDetailsFragment = new HotelGuestDetailsFragment();
        hotelGuestDetailsFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(HotelsListFragment.this);
        fragmentTransaction.replace(R.id.main_layout, hotelGuestDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();

    }
}
