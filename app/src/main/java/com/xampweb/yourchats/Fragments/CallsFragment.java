package com.xampweb.yourchats.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.xampweb.yourchats.Adapters.CallAdapter;
import com.xampweb.yourchats.Adapters.UsersAdapter;
import com.xampweb.yourchats.Models.CallModel;
import com.xampweb.yourchats.Models.Users;
import com.xampweb.yourchats.R;
import com.xampweb.yourchats.databinding.FragmentCallsBinding;
import com.xampweb.yourchats.databinding.FragmentChatsBinding;

import java.util.ArrayList;


public class CallsFragment extends Fragment {
    FragmentCallsBinding binding;





    public CallsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_calls, container, false);
        binding= FragmentCallsBinding.inflate(inflater, container, false);





        return binding.getRoot();
    }
}