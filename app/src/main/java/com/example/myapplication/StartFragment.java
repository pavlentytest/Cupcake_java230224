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

import com.example.myapplication.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;
    private OrderViewModel orderVM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container,false);
        orderVM = new ViewModelProvider(getActivity()).get(OrderViewModel.class);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.orderOneCupcake.setOnClickListener(v -> {
            orderCupcake(1);
        });
        binding.orderSixCupcakes.setOnClickListener(v -> {
            orderCupcake(6);
        });
        binding.orderTwelveCupcakes.setOnClickListener(v -> {
            orderCupcake(12);
        });
    }
    public void orderCupcake(int number) {
        orderVM.setQuantity(number);
        Navigation.findNavController(requireView()).navigate(R.id.action_startFragment_to_flavorFragment);
    }
}