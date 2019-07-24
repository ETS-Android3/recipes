package com.example.recipes.ui.search;

import android.support.annotation.NonNull;

import com.example.recipes.Utils;
import com.example.recipes.models.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter {
    private SearchView view;

    public SearchPresenter(SearchView view){
        this.view = view;
    }

    void getMealBySearch(String search){
        search = "chicken";
        view.showLoading();
        Call<Meals> mealsCall = Utils.getApi().getMealByName(search);
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setMeals(response.body().getMeals());
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
