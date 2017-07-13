# Joker
This is a gradle multiproject built for educational purposes.

## Features
- An Android app module that fetches data from a Google Cloud Endpoints REST API and passes it to an android library.
  - Includes instrumented test that properly handles multithreading.
  - Uses build variants to provide a free and paid versions
- A Google Cloud Endpoints module that provides jokes fetched from a java library.
- A java library module that provides jokes.
- An android library module that displays jokes provided to it via intent extras.

## Run it
1. Download/clone the repository and open it on Android Studio
2. Run the backend (GCE) project
3. Replace the SERVER_IP variable inside EndpointsAsyncTask.java class with your own
4. Run the android app


## License
This project is licensed under the MIT License
