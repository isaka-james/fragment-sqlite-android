package com.isaka.dineview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.isaka.dineview.database.DatabaseHelper;
import com.isaka.dineview.models.Favorite;

import java.util.List;

public class FavouritesFragment extends Fragment {

    private ListView favouritesListView;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

        favouritesListView = view.findViewById(R.id.favorites_list_view);
        databaseHelper = new DatabaseHelper(getContext());

        // Load and display the favorites
        loadFavourites();

        return view;
    }

    private void loadFavourites() {
        List<Favorite> favoriteList = databaseHelper.getAllFavorites();

        // Create a string array to display favorite names and addresses in the ListView
        String[] favoriteItems = new String[favoriteList.size()];

        for (int i = 0; i < favoriteList.size(); i++) {
            Favorite favorite = favoriteList.get(i);
            favoriteItems[i] = favorite.getRestaurantName() + "\n" + favorite.getRestaurantAddress();
        }

        // Use a basic ArrayAdapter to display the list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, favoriteItems);
        favouritesListView.setAdapter(arrayAdapter);
    }
}
