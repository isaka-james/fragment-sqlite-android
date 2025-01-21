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
import com.isaka.dineview.models.Review;

import java.util.List;

public class MyReviewsFragment extends Fragment {

    private ListView reviewsListView;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_reviews, container, false);

        reviewsListView = view.findViewById(R.id.reviews_list_view);
        databaseHelper = new DatabaseHelper(getContext());

        // Load and display the reviews
        loadMyReviews();

        return view;
    }

    private void loadMyReviews() {
        List<Review> reviewList = databaseHelper.getAllReviews();

        // Create a string array to display review titles and contents in the ListView
        String[] reviewItems = new String[reviewList.size()];

        for (int i = 0; i < reviewList.size(); i++) {
            Review review = reviewList.get(i);
            reviewItems[i] = review.getReviewTitle() + "\n" + review.getReviewContent();
        }

        // Use a basic ArrayAdapter to display the list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, reviewItems);
        reviewsListView.setAdapter(arrayAdapter);
    }
}
