package com.example.recipes.ui.search;

import com.example.recipes.models.Meals;

import java.util.List;

public interface SearchView {
    void showLoading();
    void hideLoading();
    void setMeals(List<Meals.Meal> meals);
    void onErrorLoading(String message);
}
