package com.example.myapplication;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class OrderViewModel extends ViewModel {


    public static final double PRICE_ONE = 100.00;
    private MutableLiveData<Integer> _quantity = new MutableLiveData<>(0);

    private MutableLiveData<Double> _price = new MutableLiveData<>(0.0);
    public LiveData<Double> price = _price; // это поле нужно для View

    private MutableLiveData<String> _flavor = new MutableLiveData<>("");
    public LiveData<String> flavor = _flavor;

    public void setFlavor(String f) {
       _flavor.setValue(f);
    }

    public void setQuantity(int q) {
        _quantity.setValue(q);
        calcprice();
    }

    public void calcprice() {
        _price.setValue(_quantity.getValue() * PRICE_ONE);
    }

    public List<String> getPickupDates() {

    }
}
