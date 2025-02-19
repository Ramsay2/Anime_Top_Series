📌 Features

✔ Home Screen (Anime List)
Fetch and display top anime from Jikan API.
Show Title, Episodes, Rating, and Poster Image.
Click an anime to navigate to the Anime Detail Screen.

✔ Anime Detail Screen
Fetch anime details using anime_id.
Display Title, Plot, Genres, Rating, Main Cast, and Number of Episodes.
Play trailer video using androidyoutubeplayer (or show poster image if unavailable).

✔ Modern Android Development
MVVM + Clean Architecture for scalability.
Hilt for Dependency Injection.
Jetpack Navigation for seamless screen transitions.
Retrofit for API requests.
LiveData + ViewModel for UI management.
Glide for image loading.

🛠 Tech Stack
Kotlin (Primary Language)
MVVM + Clean Architecture
Hilt (Dependency Injection)
Jetpack Navigation (Fragment-based UI)
Retrofit & Gson (API Calls)
com.pierfrancescosoffritti.androidyoutubeplayer (Video Playback)
Glide (Image Loading)

📡 API Endpoints
Fetch Top Anime:
https://api.jikan.moe/v4/top/anime
Fetch Anime Details:
https://api.jikan.moe/v4/anime/{anime_id}

🎯 Known Limitations
No Pagination – The app fetches only the first page of the top anime list.
No Custom App Icon – The app currently uses the default Android app icon.
No Offline Support – The app requires an internet connection.
Basic Error Handling – Improvements needed for network failures.
