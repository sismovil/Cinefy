# Cinefy 

**Cinefy** is a cross-platform mobile application built with **Kotlin Multiplatform (KMP)** and **Compose Multiplatform**, targeting both **Android** and **iOS**. It allows users to track, view, and manage their watched movies along with their ratings.

---

## Project Architecture: Clean Architecture

Cinefy strictly follows **Clean Architecture** principles to ensure separation of concerns, high testability, maintainability, and independence from frameworks and UI libraries. The shared codebase is organized into distinct layers:

```
edu.unicauca.sismovil.cinefy/
├── data/                      # Data Layer (Database, Drivers)
│   └── local/                 # SQLDelight database factory & drivers
├── domain/                    # Domain Layer (Core Business Logic)
│   ├── model/                 # Domain models (e.g., Movie)
│   └── repository/            # Repository interfaces & implementations
└── presentation/              # Presentation Layer (UI & State)
    ├── ui/                    # Compose screens (MovieList, MovieForm)
    └── MovieViewModel.kt      # ViewModel handling state & user actions
```

### 1. Domain Layer (`domain/`)
* **Role**: The heart of the application. It contains pure business logic and enterprise rules. It is completely independent of the UI, frameworks, and data sources.
* **Components**:
  * [Movie.kt](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/domain/model/Movie.kt): Pure domain data class representing a movie entity.
  * [MovieRepository.kt](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/domain/repository/MovieRepository.kt): Abstract interface defining data operations (`getAllMovies`, `insertMovie`, `deleteMovie`).

### 2. Data Layer (`data/`)
* **Role**: Manages data sources such as local databases (SQLDelight) and network services.
* **Components**:
  * [MovieRepositoryImpl.kt](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/domain/repository/MovieRepositoryImpl.kt): Concrete implementation of `MovieRepository` that interacts with the SQLDelight database (`CinefyDatabase`).
  * [DatabaseDriverFactory.kt](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/data/local/DatabaseDriverFactory.kt): Platform-specific abstraction for creating SQLite database drivers on Android and iOS.

### 3. Presentation Layer (`presentation/`)
* **Role**: Handles UI rendering and state management using Jetpack Compose Multiplatform and Jetpack Lifecycle ViewModels.
* **Components**:
  * [MovieViewModel.kt](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/presentation/MovieViewModel.kt): Manages UI state (`movies`) and delegates user actions to the domain repository.
  * `ui/`: Compose UI screens ([MovieListScreen.kt](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/presentation/ui/MovieListScreen.kt), [MovieFormScreen.kt](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/presentation/ui/MovieFormScreen.kt), [CinefyApp.kt](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/presentation/ui/CinefyApp.kt)).

---

## 📐 Application of SOLID Principles

Cinefy incorporates SOLID software design principles throughout its architecture:

### 1. **S** - Single Responsibility Principle (SRP)
* Each class has one clear reason to change.
* [MovieViewModel](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/presentation/MovieViewModel.kt) exclusively manages UI state and user intent.
* [MovieRepositoryImpl](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/domain/repository/MovieRepositoryImpl.kt) exclusively handles data persistence and database operations.
* Compose screens (`MovieListScreen`, `MovieFormScreen`) focus solely on rendering UI components and dispatching user interactions.

### 2. **O** - Open/Closed Principle (OCP)
* Software entities are open for extension but closed for modification.
* The presentation and domain layers interact with `MovieRepository` (interface) rather than concrete data sources. New data sources (e.g., remote API synchronization or caching layers) can be added by implementing `MovieRepository` without altering existing ViewModels or UI code.

### 3. **L** - Liskov Substitution Principle (LSP)
* Subtypes must be substitutable for their base types without altering correctness.
* `MovieRepositoryImpl` implements `MovieRepository` and can be seamlessly substituted anywhere a `MovieRepository` is expected (e.g., in `MovieViewModel`).

### 4. **I** - Interface Segregation Principle (ISP)
* Clients should not be forced to depend upon interfaces that they do not use.
* `MovieRepository` defines a focused, cohesive contract specifically tailored to movie CRUD operations required by the application.

### 5. **D** - Dependency Inversion Principle (DIP)
* High-level modules do not depend on low-level modules; both depend on abstractions.
* [MovieViewModel](file:///Users/cfigmart/programming/aplimovil/20262/tmp2/Cinefy/shared/src/commonMain/kotlin/edu/unicauca/sismovil/cinefy/presentation/MovieViewModel.kt) depends on the `MovieRepository` interface rather than concrete SQLDelight database queries or database drivers. Dependencies are injected across layers.

---

## 🚀 Getting Started & Running the Apps

* [/iosApp](./iosApp/iosApp) contains the native iOS entry point and SwiftUI wrapper.
* [/shared](./shared/src) contains the shared Kotlin Multiplatform code and Compose Multiplatform UI.

### Running Android
Use the run configurations in Android Studio or run via terminal:
```bash
./gradlew :androidApp:assembleDebug
```

### Running iOS
Open the [/iosApp](./iosApp) directory in Xcode and run the app on an iOS simulator or physical device.

### Running Tests
* Android tests: `./gradlew :shared:testAndroidHostTest`
* iOS tests: `./gradlew :shared:iosSimulatorArm64Test`

---

## Acknowledgments & AI Assistance

This project was developed with the assistance of AI (Artificial Intelligence) tools, which aided in architectural guidance, code implementation following Clean Architecture and SOLID principles, UI design refinements, and documentation.
