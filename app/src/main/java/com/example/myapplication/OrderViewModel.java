package com.example.myapplication;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class OrderViewModel extends ViewModel {


    public static final double PRICE_ONE = 100.00;
    private MutableLiveData<Integer> _quantity = new MutableLiveData<>(0);

    private MutableLiveData<Double> _price = new MutableLiveData<>(0.0);
    public LiveData<Double> price = _price; // это поле нужно для View

    private MutableLiveData<String> _flavor = new MutableLiveData<>("");
    public LiveData<String> flavor = _flavor;


    private MutableLiveData<String> _date = new MutableLiveData<>("");
    public LiveData<String> date = _date;

    public List<String> dateOptions = getPickupDates();

    public void setDate(String d) {
        _date.setValue(d);
    }

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
        ArrayList<String> options = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM d", Locale.getDefault());
        Calendar calendar = new GregorianCalendar();
        for(int i=0; i<4; i++) {
            options.add(formatter.format(calendar.getTime()));
            calendar.add(Calendar.DATE,1);
        }
        return options;
    }
}
