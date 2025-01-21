package com.isaka.dineview.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.isaka.dineview.models.Favorite;
import com.isaka.dineview.models.Review;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dineview.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables for favorites and reviews
        db.execSQL("CREATE TABLE favorites (id INTEGER PRIMARY KEY, restaurant_name TEXT, restaurant_address TEXT)");
        db.execSQL("CREATE TABLE reviews (id INTEGER PRIMARY KEY, review_title TEXT, review_content TEXT)");

        // Insert sample data into the 'favorites' table
        db.execSQL("INSERT INTO favorites (restaurant_name, restaurant_address) VALUES ('Pizza Palace', '123 Main St')");
        db.execSQL("INSERT INTO favorites (restaurant_name, restaurant_address) VALUES ('Sushi World', '456 Sushi Rd')");
        db.execSQL("INSERT INTO favorites (restaurant_name, restaurant_address) VALUES ('Burger Haven', '789 Burger Ln')");
        db.execSQL("INSERT INTO favorites (restaurant_name, restaurant_address) VALUES ('Taco Fiesta', '101 Taco St')");
        db.execSQL("INSERT INTO favorites (restaurant_name, restaurant_address) VALUES ('Pasta House', '202 Pasta Blvd')");

        // Insert sample data into the 'reviews' table
        db.execSQL("INSERT INTO reviews (review_title, review_content) VALUES ('Great Pizza', 'Pizza Palace offers the best pizza in town!')");
        db.execSQL("INSERT INTO reviews (review_title, review_content) VALUES ('Amazing Sushi', 'Sushi World has the freshest sushi, highly recommend!')");
        db.execSQL("INSERT INTO reviews (review_title, review_content) VALUES ('Delicious Burgers', 'Burger Haven has a wide variety of juicy burgers!')");
        db.execSQL("INSERT INTO reviews (review_title, review_content) VALUES ('Tasty Tacos', 'Taco Fiesta serves up some of the best tacos I’ve ever had!')");
        db.execSQL("INSERT INTO reviews (review_title, review_content) VALUES ('Perfect Pasta', 'Pasta House prepares fresh and tasty pasta with a variety of sauces!')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade if needed
        db.execSQL("DROP TABLE IF EXISTS favorites");
        db.execSQL("DROP TABLE IF EXISTS reviews");
        onCreate(db);
    }

//    public Cursor getFavorites() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("SELECT id AS _id, restaurant_name, restaurant_address FROM favorites", null);
//    }

    public List<Favorite> getAllFavorites() {
        List<Favorite> favorites = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT id AS _id, restaurant_name, restaurant_address FROM favorites", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_id"));
                @SuppressLint("Range") String restaurantName = cursor.getString(cursor.getColumnIndex("restaurant_name"));
                @SuppressLint("Range") String restaurantAddress = cursor.getString(cursor.getColumnIndex("restaurant_address"));
                favorites.add(new Favorite(id, restaurantName, restaurantAddress));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return favorites;
    }

    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT id AS _id, review_title, review_content FROM reviews", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_id"));
                @SuppressLint("Range") String reviewTitle = cursor.getString(cursor.getColumnIndex("review_title"));
                @SuppressLint("Range") String reviewContent = cursor.getString(cursor.getColumnIndex("review_content"));
                reviews.add(new Review(id, reviewTitle, reviewContent));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return reviews;
    }

//    public Cursor getMyReviews() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("SELECT id AS _id, review_title, review_content FROM reviews", null);
//    }




    // methods to add
    public void addFavorite(Favorite favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("restaurant_name", favorite.getRestaurantName());
        values.put("restaurant_address", favorite.getRestaurantAddress());

        db.insert("favorites", null, values);
    }

    // Method to add a new review
    public void addReview(Review review) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("review_title", review.getReviewTitle());
        values.put("review_content", review.getReviewContent());

        db.insert("reviews", null, values);
    }
}
