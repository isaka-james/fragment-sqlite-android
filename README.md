# Fragment SQLite Android

This is an Android project that demonstrates how to use fragments and SQLite database to manage and display restaurant reviews and favorites in a simple app. The app features a navigation drawer to switch between different sections such as "Home," "My Reviews," and "Favorites." Each section dynamically loads a corresponding fragment, with data sourced from an SQLite database.

## Features
- **Home Fragment**: Displays a welcome message or introductory content.
- **My Reviews Fragment**: Shows a list of reviews that the user has submitted, sourced from the SQLite database.
- **Favorites Fragment**: Displays a list of favorite restaurants added by the user, retrieved from the SQLite database.
- **Navigation Drawer**: Allows easy switching between different sections of the app.

## Why I Created This Project

Many people asked me how I implemented fragments with SQLite in an Android project. To make it easier for everyone to understand and replicate, I decided to share this project. It demonstrates the simplicity of working with fragments, SQLite, and navigation drawers in Android development. This project was built to showcase how easily such functionality can be implemented with basic concepts of Android.

## Technologies Used
- Android SDK
- SQLite Database for data persistence
- Fragments for dynamic UI rendering
- Java for Android development

## Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/isaka-james/fragment-sqlite-android
    ```

2. **Import the project** into Android Studio.

3. **Run the app** on an Android device or emulator.

4. **Features to test**:
    - Add new restaurant reviews and favorites via the app's interface.
    - Navigate between "Home," "My Reviews," and "Favorites" using the navigation drawer.
    - I have created some methods to insert the new datasets, you can see them on the `DatabaseHelper` class. Although I have not used them, but you can use them if you want.

## Contributing

If you have any improvements or suggestions, feel free to fork this project and submit a pull request.

## License

This project is open-source and available under the MIT License.