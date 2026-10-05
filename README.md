<p align="center">
  <img src="https://raw.githubusercontent.com/abdoulrl2028-cloud-Dev/abdoulrl2028-cloud-Dev/main/assets/projects/extrato.jpg" alt="Bank statement app" width="100%">
</p>

# Bank statement (Kotlin)

Sample project with an Android app (Kotlin, Room, Retrofit) and a small Spring Boot server.

## Structure

- `app/` — Android module with source, Room, and Retrofit
- `server/` — Spring Boot API that exposes `/transactions` with mock data

## Run

1. Start the server (Java 17 and Maven):

```bash
cd server
mvn spring-boot:run
```

2. Run the Android app on an emulator. Use `10.0.2.2:8080` as `BASE_URL` in `ApiModule`.

## Notes

- The code is intentionally simple and educational.
- Adjust dependency versions in `app/build.gradle` for your setup.

License: MIT (`LICENSE`)
