package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentFlavorBinding;
import com.example.myapplication.databinding.FragmentPickupBinding;


public class PickupFragment extends Fragment {

    private FragmentPickupBinding binding;
    private OrderViewModel orderVM;

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          binding = FragmentPickupBinding.inflate(inflater, container, false);
          orderVM = new ViewModelProvider(getActivity()).get(OrderViewModel.class);
          binding.setViewModel(orderVM);
          return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.action_pickupFragment_to_summaryFragment);
            }
        });
    }
}