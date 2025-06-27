# Team Matches App

This is an Android application developed for the university course on mobile development.

The purpose of the application is to display matches between teams from popular universes such as DC and Marvel. After selecting a match, the app shows the members of each team along with their photos.

## 📱 Features
- Displays fictional matches between popular teams (e.g., DC, Marvel).
- Shows team details, including member names and photos.
- Supports image loading using Picasso.
- Uses JSON parsing to fetch and display data from remote services.
- Provides a responsive layout using `LinearLayout` and `ConstraintLayout`.

## 🚀 Technologies Used
- Android Studio
- Java
- Picasso (for image loading)
- JSON Parsing
- HTTP Requests (via provided services)
- XAMPP (for running local PHP server)

## 🖥️ Backend Setup (XAMPP)
The application communicates with backend services via HTTP requests. These services are written in PHP and can be run locally using XAMPP.

### Backend Files:
- `getFixtures.php`
- `getMembers.php`
- `match.sql` (SQL file to create and populate the database)

### Setup Instructions:
1. **Install [XAMPP](https://www.apachefriends.org/index.html).**

2. **Database Setup:**
   - Start Apache and MySQL from the XAMPP Control Panel.
   - Open phpMyAdmin by visiting `http://localhost/phpmyadmin`.
   - Insert the database named `matches`.
   - Import the provided `match.sql` file into this database.

3. **PHP Setup:**
   - Place the provided PHP files (`getFixtures.php`, `getMembers.php`) inside the `htdocs/matches` folder.
   - You can access the services via:
     - `http://localhost/matches/getFixtures.php`
     - `http://localhost/matches/getMembers.php`

4. **Update IP Address in App:**
   - If using the local server, make sure to put your ip address.


## ⚙️ How to Run
1. Clone the repository:
   ```bash
    git clone https://github.com/KiriakiKad/Android-TeamMatchesApp/AndroidApp.git
2. Open the project in Android Studio (current version Electric Eel 2022.1.1)
3. Ensure that network access is enabled by adding the following in AndroidManifest.xml:
   ```bash
    android:networkSecurityConfig="@xml/network_security_config"
    android:usesCleartextTraffic="true"
4. Add your ip to the network_security_config.xml file in the res/xml directory:
5. Build and run the app on an emulator or physical device.

ℹ️**Author**

Developed by Kiriaki Maria Kadrefi for educational purposes.




