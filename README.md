AndroidLauncher/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/launcher/
│   │       │   ├── LauncherApplication.kt          // Application entry point, Hilt setup
│   │       │   ├── MainActivity.kt                 // Single Activity for Jetpack Compose navigation
│   │       │   ├── di/                             // Dependency Injection modules (Hilt)
│   │       │   │   ├── AppModule.kt                // Provides application-wide dependencies
│   │   │   │   │   ├── DatabaseModule.kt           // Provides Room Database instances and DAOs
│   │   │   │   │   ├── RepositoryModule.kt         // Provides Repository implementations
│   │   │   │   │   └── ViewModelModule.kt          // Provides ViewModel dependencies (if custom injection needed)
│   │       │   └── utils/                          // Application-specific utilities
│   │       │       ├── Constants.kt                // Global constants for the app module
│   │       │       ├── Extensions.kt               // General app-level Kotlin extensions
│   │       │       └── PermissionUtils.kt          // Utility for common app permissions
│   │       ├── res/                                // Android resources (layouts, drawables, values)
│   │       └── AndroidManifest.xml                 // Application manifest
│   ├── build.gradle.kts                            // Gradle build script for the app module
│   └── proguard-rules.pro                          // ProGuard/R8 rules for code shrinking and obfuscation
├── core/                                           // Core modules: foundational, reusable, Android-independent (mostly)
│   ├── common/                                     // Common utilities, base classes, and shared models
│   │   ├── src/main/java/com/launcher/core/common/
│   │   │   ├── base/                               // Base classes for Activities, Fragments, ViewModels, Repositories
│   │   │   │   ├── BaseActivity.kt
│   │   │   │   ├── BaseFragment.kt
│   │   │   │   ├── BaseViewModel.kt
│   │   │   │   └── BaseRepository.kt
│   │   │   ├── utils/                              // General utility functions
│   │   │   │   ├── Logger.kt
│   │   │   │   ├── DateUtils.kt
│   │   │   │   ├── StringUtils.kt
│   │   │   │   └── ValidationUtils.kt
│   │   │   ├── extensions/                         // Kotlin extension functions for common types
│   │   │   │   ├── ContextExtensions.kt
│   │   │   │   ├── ViewExtensions.kt
│   │   │   │   ├── FlowExtensions.kt
│   │   │   │   └── CollectionExtensions.kt
│   │   │   ├── models/                             // Common data models for result handling and UI state
│   │   │   │   ├── Result.kt                       // Sealed class for operation results (Success/Error)
│   │   │   │   ├── Resource.kt                     // Sealed class for data loading states (Loading/Success/Error)
│   │   │   │   └── UiState.kt                      // Generic UI state model
│   │   │   └── Constants.kt                        // Common constants shared across core modules
│   │   └── build.gradle.kts                        // Gradle build script for the common module
│   ├── database/                                   // Data Layer: Room Database module
│   │   ├── src/main/java/com/launcher/core/database/
│   │   │   ├── LauncherDatabase.kt                 // Room database definition
│   │   │   ├── entities/                           // Room entities (database table schemas)
│   │   │   │   ├── AppEntity.kt
│   │   │   │   ├── FolderEntity.kt
│   │   │   │   ├── ShortcutEntity.kt
│   │   │   │   ├── WidgetEntity.kt
│   │   │   │   ├── WallpaperEntity.kt
│   │   │   │   └── SettingsEntity.kt
│   │   │   ├── dao/                                // Data Access Objects (DAOs) for database operations
│   │   │   │   ├── AppDao.kt
│   │   │   │   ├── FolderDao.kt
│   │   │   │   ├── ShortcutDao.kt
│   │   │   │   ├── WidgetDao.kt
│   │   │   │   ├── WallpaperDao.kt
│   │   │   │   └── SettingsDao.kt
│   │   │   ├── converters/                         // Type converters for Room (e.g., for custom data types)
│   │   │   │   ├── DateConverter.kt
│   │   │   │   ├── ListConverter.kt
│   │   │   │   └── PositionConverter.kt
│   │   │   └── migrations/                         // Database migration scripts
│   │   │       ├── Migration1to2.kt
│   │   │       ├── Migration2to3.kt
│   │   │       └── MigrationHelper.kt
│   │   └── build.gradle.kts
│   ├── datastore/                                  // Data Layer: Jetpack DataStore module
│   │   ├── src/main/java/com/launcher/core/datastore/
│   │   │   ├── PreferencesManager.kt               // Generic manager for DataStore preferences
│   │   │   ├── SettingsDataStore.kt                // DataStore for application settings
│   │   │   ├── ThemeDataStore.kt                   // DataStore for theme preferences
│   │   │   └── serializers/                        // Serializers for custom DataStore types (e.g., Proto DataStore)
│   │   │       ├── SettingsSerializer.kt
│   │   │       └── ThemeSerializer.kt
│   │   └── build.gradle.kts
│   ├── ui/                                         // UI Layer: Shared UI components and theming
│   │   ├── src/main/java/com/launcher/core/ui/
│   │   │   ├── theme/                              // Jetpack Compose theming definitions
│   │   │   │   ├── Color.kt
│   │   │   │   ├── Shape.kt
│   │   │   │   ├── Theme.kt
│   │   │   │   ├── Type.kt
│   │   │   │   └── Dimension.kt
│   │   │   ├── components/                         // Reusable Jetpack Compose UI components
│   │   │   │   ├── AppIcon.kt
│   │   │   │   ├── FolderIcon.kt
│   │   │   │   ├── SearchBar.kt
│   │   │   │   ├── LauncherButton.kt
│   │   │   │   ├── LauncherCard.kt
│   │   │   │   ├── LauncherDialog.kt
│   │   │   │   ├── LoadingIndicator.kt
│   │   │   │   └── EmptyState.kt
│   │   │   ├── animations/                         // Reusable Jetpack Compose animation definitions
│   │   │   │   ├── SlideAnimations.kt
│   │   │   │   ├── FadeAnimations.kt
│   │   │   │   ├── ScaleAnimations.kt
│   │   │   │   └── SpringAnimations.kt
│   │   │   └── utils/                              // Utilities for Compose UI
│   │   │       ├── ComposeUtils.kt
│   │   │       ├── PreviewUtils.kt
│   │   │       └── ThemeUtils.kt
│   │   └── build.gradle.kts
│   └── network/                                    // Data Layer: Network communication module
│       ├── src/main/java/com/launcher/core/network/
│       │   ├── NetworkManager.kt                   // Manages network client setup (e.g., Retrofit, OkHttp)
│       │   ├── ConnectivityObserver.kt             // Observes network connectivity status
│       │   ├── api/                                // Retrofit API interfaces
│       │   │   ├── WallpaperApi.kt
│       │   │   ├── IconPackApi.kt
│       │   │   └── UpdateApi.kt
│       │   ├── models/                             // Data Transfer Objects (DTOs) for network responses
│       │   │   ├── WallpaperResponse.kt
│       │   │   ├── IconPackResponse.kt
│       │   │   └── UpdateResponse.kt
│       │   └── interceptors/                       // OkHttp interceptors (e.g., for auth, logging, caching)
│       │       ├── AuthInterceptor.kt
│       │       ├── LoggingInterceptor.kt
│       │       └── CacheInterceptor.kt
│       └── build.gradle.kts
├── features/                                       // Feature modules: Each module represents a distinct feature
│   ├── homescreen/                                 // Feature: Home Screen
│   │   ├── src/main/java/com/launcher/feature/homescreen/
│   │   │   ├── presentation/                       // UI Layer & ViewModel Layer for HomeScreen
│   │   │   │   ├── HomeScreenViewModel.kt          // ViewModel for HomeScreen UI logic and state
│   │   │   │   ├── HomeScreenState.kt              // Data class representing HomeScreen UI state
│   │   │   │   ├── HomeScreenEvent.kt              // Sealed class for UI events from HomeScreen
│   │   │   │   ├── components/                     // Jetpack Compose UI components specific to HomeScreen
│   │   │   │   │   ├── HomeScreenContent.kt
│   │   │   │   │   ├── AppGrid.kt
│   │   │   │   │   ├── PageIndicator.kt
│   │   │   │   │   ├── DragDropManager.kt
│   │   │   │   │   └── GestureHandler.kt
│   │   │   │   └── navigation/                     // Navigation graph/routes for HomeScreen
│   │   │   │       └── HomeScreenNavigation.kt
│   │   │   ├── domain/                             // Domain Layer for HomeScreen
│   │   │   │   ├── models/                         // Pure Kotlin domain models for HomeScreen
│   │   │   │   │   ├── HomeScreenItem.kt
│   │   │   │   │   ├── GridPosition.kt
│   │   │   │   │   ├── Page.kt
│   │   │   │   │   └── DragState.kt
│   │   │   │   ├── usecases/                       // Use Cases (Interactors) for HomeScreen business logic
│   │   │   │   │   ├── GetHomeScreenItemsUseCase.kt
│   │   │   │   │   ├── MoveItemUseCase.kt
│   │   │   │   │   ├── AddToFolderUseCase.kt
│   │   │   │   │   ├── RemoveFromFolderUseCase.kt
│   │   │   │   │   └── UpdatePageLayoutUseCase.kt
│   │   │   │   └── repository/                     // Interface for HomeScreen data access
│   │   │   │       └── HomeScreenRepository.kt
│   │   │   └── data/                               // Data Layer for HomeScreen
│   │   │       ├── repository/                     // Implementation of HomeScreenRepository
│   │   │       │   └── HomeScreenRepositoryImpl.kt
│   │   │       ├── datasource/                     // Data sources for HomeScreen (local, remote, system)
│   │   │       │   ├── HomeScreenLocalDataSource.kt
│   │   │       │   └── HomeScreenRemoteDataSource.kt
│   │   │       └── mappers/                        // Mappers between data entities and domain models
│   │   │           ├── HomeScreenMapper.kt
│   │   │           └── GridPositionMapper.kt
│   │   └── build.gradle.kts
│   ├── appdrawer/                                  // Feature: App Drawer
│   │   ├── src/main/java/com/launcher/feature/appdrawer/
│   │   │   ├── presentation/
│   │   │   │   ├── AppDrawerViewModel.kt
│   │   │   │   ├── AppDrawerState.kt
│   │   │   │   ├── AppDrawerEvent.kt
│   │   │   │   ├── components/
│   │   │   │   │   ├── AppDrawerContent.kt
│   │   │   │   │   ├── AppList.kt
│   │   │   │   │   ├── AppGrid.kt
│   │   │   │   │   ├── AlphabetScroller.kt
│   │   │   │   │   ├── CategoryTabs.kt
│   │   │   │   │   └── AppSorter.kt
│   │   │   │   └── navigation/
│   │   │   │       └── AppDrawerNavigation.kt
│   │   │   ├── domain/
│   │   │   │   ├── models/
│   │   │   │   │   ├── AppInfo.kt
│   │   │   │   │   ├── AppCategory.kt
│   │   │   │   │   ├── SortOption.kt
│   │   │   │   │   └── FilterOption.kt
│   │   │   │   ├── usecases/
│   │   │   │   │   ├── GetAllAppsUseCase.kt
│   │   │   │   │   ├── SearchAppsUseCase.kt
│   │   │   │   │   ├── SortAppsUseCase.kt
│   │   │   │   │   ├── FilterAppsByCategory.kt
│   │   │   │   │   └── LaunchAppUseCase.kt
│   │   │   │   └── repository/
│   │   │   │       └── AppDrawerRepository.kt
│   │   │   └── data/
│   │   │       ├── repository/
│   │   │       │   └── AppDrawerRepositoryImpl.kt
│   │   │       ├── datasource/
│   │   │       │   ├── AppDrawerLocalDataSource.kt
│   │   │       │   └── SystemAppsDataSource.kt     // Data source for system-installed apps
│   │   │       └── mappers/
│   │   │           ├── AppInfoMapper.kt
│   │   │           └── CategoryMapper.kt
│   │   └── build.gradle.kts
│   ├── dock/                                       // Feature: Dock
│   │   ├── src/main/java/com/launcher/feature/dock/
│   │   │   ├── presentation/
│   │   │   │   ├── DockViewModel.kt
│   │   │   │   ├── DockState.kt
│   │   │   │   ├── DockEvent.kt
│   │   │   │   ├── components/
│   │   │   │   │   ├── DockContent.kt
│   │   │   │   │   ├── DockIcon.kt
│   │   │   │   │   ├── DockFolder.kt
│   │   │   │   │   └── DockAnimations.kt
│   │   │   │   └── navigation/
│   │   │   │       └── DockNavigation.kt
│   │   │   ├── domain/
│   │   │   │   ├── models/
│   │   │   │   │   ├── DockItem.kt
│   │   │   │   │   ├── DockPosition.kt
│   │   │   │   │   └── DockSettings.kt
│   │   │   │   ├── usecases/
│   │   │   │   │   ├── GetDockItemsUseCase.kt
│   │   │   │   │   ├── AddToDockUseCase.kt
│   │   │   │   │   ├── RemoveFromDockUseCase.kt
│   │   │   │   │   └── ReorderDockItemsUseCase.kt
│   │   │   │   └── repository/
│   │   │   │       └── DockRepository.kt
│   │   │   └── data/
│   │   │       ├── repository/
│   │   │       │   └── DockRepositoryImpl.kt
│   │   │       ├── datasource/
│   │   │       │   └── DockLocalDataSource.kt
│   │   │       └── mappers/
│   │   │           └── DockItemMapper.kt
│   │   └── build.gradle.kts
│   ├── wallpaper/                                  // Feature: Wallpaper Management
│   │   ├── src/main/java/com/launcher/feature/wallpaper/
│   │   │   ├── presentation/
│   │   │   │   ├── WallpaperViewModel.kt
│   │   │   │   ├── WallpaperState.kt
│   │   │   │   ├── WallpaperEvent.kt
│   │   │   │   ├── components/
│   │   │   │   │   ├── WallpaperContent.kt
│   │   │   │   │   ├── WallpaperGrid.kt
│   │   │   │   │   ├── WallpaperPreview.kt
│   │   │   │   │   ├── LiveWallpaperManager.kt
│   │   │   │   │   └── WallpaperCropper.kt
│   │   │   │   └── navigation/
│   │   │   │       └── WallpaperNavigation.kt
│   │   │   ├── domain/
│   │   │   │   ├── models/
│   │   │   │   │   ├── Wallpaper.kt
│   │   │   │   │   ├── WallpaperType.kt
│   │   │   │   │   ├── WallpaperSource.kt
│   │   │   │   │   └── WallpaperSettings.kt
│   │   │   │   ├── usecases/
│   │   │   │   │   ├── GetWallpapersUseCase.kt
│   │   │   │   │   ├── SetWallpaperUseCase.kt
│   │   │   │   │   ├── DownloadWallpaperUseCase.kt
│   │   │   │   │   ├── GetLiveWallpapersUseCase.kt
│   │   │   │   │   └── CropWallpaperUseCase.kt
│   │   │   │   └── repository/
│   │   │   │       └── WallpaperRepository.kt
│   │   │   └── data/
│   │   │       ├── repository/
│   │   │       │   └── WallpaperRepositoryImpl.kt
│   │   │       ├── datasource/
│   │   │       │   ├── WallpaperLocalDataSource.kt
│   │   │       │   ├── WallpaperRemoteDataSource.kt
│   │   │       │   └── SystemWallpaperDataSource.kt  // Data source for system wallpapers
│   │   │       └── mappers/
│   │   │           └── WallpaperMapper.kt
│   │   └── build.gradle.kts
│   ├── widgets/                                     // Feature: Widget Management
│   │   ├── src/main/java/com/launcher/feature/widgets/
│   │   │   ├── presentation/
│   │   │   │   ├── WidgetsViewModel.kt
│   │   │   │   ├── WidgetsState.kt
│   │   │   │   ├── WidgetsEvent.kt
│   │   │   │   ├── components/
│   │   │   │   │   ├── WidgetsContent.kt
│   │   │   │   │   ├── WidgetGrid.kt
│   │   │   │   │   ├── WidgetPreview.kt
│   │   │   │   │   ├── WidgetHost.kt
│   │   │   │   │   ├── WidgetResizer.kt
│   │   │   │   │   └── WidgetPicker.kt
│   │   │   │   └── navigation/
│   │   │   │       └── WidgetsNavigation.kt
│   │   │   ├── domain/
│   │   │   │   ├── models/
│   │   │   │   │   ├── WidgetInfo.kt
│   │   │   │   │   ├── WidgetSize.kt
│   │   │   │   │   ├── WidgetPosition.kt
│   │   │   │   │   └── WidgetProvider.kt
│   │   │   │   ├── usecases/
│   │   │   │   │   ├── GetAvailableWidgetsUseCase.kt
│   │   │   │   │   ├── AddWidgetUseCase.kt
│   │   │   │   │   ├── RemoveWidgetUseCase.kt
│   │   │   │   │   ├── ResizeWidgetUseCase.kt
│   │   │   │   │   └── MoveWidgetUseCase.kt
│   │   │   │   └── repository/
│   │   │   │       └── WidgetsRepository.kt
│   │   │   └── data/
│   │   │       ├── repository/
│   │   │       │   └── WidgetsRepositoryImpl.kt
│   │   │       ├── datasource/
│   │   │       │   ├── WidgetsLocalDataSource.kt
│   │   │       │   └── SystemWidgetsDataSource.kt   // Data source for system widgets
│   │   │       └── mappers/
│   │   │           └── WidgetInfoMapper.kt
│   │   └── build.gradle.kts
│   ├── search/                                      // Feature: Search
│   │   ├── src/main/java/com/launcher/feature/search/
│   │   │   ├── presentation/
│   │   │   │   ├── SearchViewModel.kt
│   │   │   │   ├── SearchState.kt
│   │   │   │   ├── SearchEvent.kt
│   │   │   │   ├── components/
│   │   │   │   │   ├── SearchContent.kt
│   │   │   │   │   ├── SearchResults.kt
│   │   │   │   │   ├── SearchSuggestions.kt
│   │   │   │   │   ├── SearchFilters.kt
│   │   │   │   │   └── VoiceSearch.kt
│   │   │   │   └── navigation/
│   │   │   │       └── SearchNavigation.kt
│   │   │   ├── domain/
│   │   │   │   ├── models/
│   │   │   │   │   ├── SearchResult.kt
│   │   │   │   │   ├── SearchQuery.kt
│   │   │   │   │   ├── SearchFilter.kt
│   │   │   │   │   └── SearchSuggestion.kt
│   │   │   │   ├── usecases/
│   │   │   │   │   ├── SearchAppsUseCase.kt
│   │   │   │   │   ├── SearchContactsUseCase.kt
│   │   │   │   │   ├── SearchSettingsUseCase.kt
│   │   │   │   │   ├── SearchWebUseCase.kt
│   │   │   │   │   └── GetSearchSuggestionsUseCase.kt
│   │   │   │   └── repository/
│   │   │   │       └── SearchRepository.kt
│   │   │   └── data/
│   │   │       ├── repository/
│   │   │       │   └── SearchRepositoryImpl.kt
│   │   │       ├── datasource/
│   │   │       │   ├── SearchLocalDataSource.kt
│   │   │       │   ├── SearchRemoteDataSource.kt
│   │   │       │   └── ContactsDataSource.kt         // Data source for system contacts
│   │   │       └── mappers/
│   │   │           └── SearchResultMapper.kt
│   │   └── build.gradle.kts
│   ├── settings/                                    // Feature: Settings
│   │   ├── src/main/java/com/launcher/feature/settings/
│   │   │   ├── presentation/
│   │   │   │   ├── SettingsViewModel.kt
│   │   │   │   ├── SettingsState.kt
│   │   │   │   ├── SettingsEvent.kt
│   │   │   │   ├── components/
│   │   │   │   │   ├── SettingsContent.kt
│   │   │   │   │   ├── SettingsGroup.kt
│   │   │   │   │   ├── SettingsItem.kt
│   │   │   │   │   ├── ThemeSelector.kt
│   │   │   │   │   ├── LayoutSelector.kt
│   │   │   │   │   ├── GestureSettings.kt
│   │   │   │   │   └── BackupRestore.kt
│   │   │   │   └── navigation/
│   │   │   │       └── SettingsNavigation.kt
│   │   │   ├── domain/
│   │   │   │   ├── models/
│   │   │   │   │   ├── LauncherSettings.kt
│   │   │   │   │   ├── ThemeSettings.kt
│   │   │   │   │   ├── LayoutSettings.kt
│   │   │   │   │   ├── GestureSettings.kt
│   │   │   │   │   └── BackupData.kt
│   │   │   │   ├── usecases/
│   │   │   │   │   ├── GetSettingsUseCase.kt
│   │   │   │   │   ├── UpdateSettingsUseCase.kt
│   │   │   │   │   ├── ExportSettingsUseCase.kt
│   │   │   │   │   ├── ImportSettingsUseCase.kt
│   │   │   │   │   └── ResetSettingsUseCase.kt
│   │   │   │   └── repository/
│   │   │   │       └── SettingsRepository.kt
│   │   │   └── data/
│   │   │       ├── repository/
│   │   │       │   └── SettingsRepositoryImpl.kt
│   │   │       ├── datasource/
│   │   │       │   ├── SettingsLocalDataSource.kt
│   │   │       │   └── SettingsRemoteDataSource.kt
│   │   │       └── mappers/
│   │   │           └── SettingsMapper.kt
│   │   └── build.gradle.kts
│   └── shortcuts/                                   // Feature: Shortcuts
│       ├── src/main/java/com/launcher/feature/shortcuts/
│       │   ├── presentation/
│       │   │   ├── ShortcutsViewModel.kt
│       │   │   ├── ShortcutsState.kt
│       │   │   ├── ShortcutsEvent.kt
│       │   │   ├── components/
│       │   │   │   ├── ShortcutsContent.kt
│       │   │   │   ├── ShortcutsList.kt
│       │   │   │   ├── ShortcutCreator.kt
│   │   │   │   │   └── ShortcutEditor.kt
│       │   │   └── navigation/
│       │   │       └── ShortcutsNavigation.kt
│       │   ├── domain/
│       │   │   ├── models/
│       │   │   │   ├── LauncherShortcut.kt
│       │   │   │   ├── ShortcutType.kt
│       │   │   │   └── ShortcutAction.kt
│       │   │   ├── usecases/
│       │   │   │   ├── GetShortcutsUseCase.kt
│       │   │   │   ├── CreateShortcutUseCase.kt
│       │   │   │   ├── DeleteShortcutUseCase.kt
│       │   │   │   └── UpdateShortcutUseCase.kt
│       │   │   └── repository/
│       │   │       └── ShortcutsRepository.kt
│       │   └── data/
│       │       ├── repository/
│       │       │   └── ShortcutsRepositoryImpl.kt
│       │       ├── datasource/
│       │       │   ├── ShortcutsLocalDataSource.kt
│       │       │   └── SystemShortcutsDataSource.kt  // Data source for system shortcuts
│       │       └── mappers/
│       │           └── ShortcutMapper.kt
│       └── build.gradle.kts
├── performance/                                    // Performance monitoring and benchmarking module
│   ├── src/main/java/com/launcher/performance/
│   │   ├── PerformanceMonitor.kt                   // High-level performance monitoring
│   │   ├── BenchmarkReporter.kt                    // Reports benchmarking results
│   │   ├── metrics/                                // Definitions for various performance metrics
│   │   │   ├── StartupMetrics.kt
│   │   │   ├── FrameMetrics.kt
│   │   │   └── MemoryMetrics.kt
│   │   ├── tools/                                  // Integration with Android performance tools
│   │   │   ├── MacrobenchmarkTool.kt
│   │   │   └── MicrobenchmarkTool.kt
│   │   └── utils/                                  // Utilities for performance measurement
│   │       ├── TraceUtils.kt
│   │       └── CpuProfiler.kt
│   └── build.gradle.kts
├── sync/                                           // Data synchronization module
│   ├── src/main/java/com/launcher/sync/
│   │   ├── SyncManager.kt                          // Manages overall synchronization logic
│   │   ├── SyncScheduler.kt                        // Schedules sync operations (e.g., using WorkManager)
│   │   ├── models/                                 // Models for sync operations and status
│   │   │   ├── SyncConfig.kt
│   │   │   ├── SyncResult.kt
│   │   │   └── SyncStatus.kt
│   │   ├── adapters/                               // Adapters for different data types to be synced
│   │   │   ├── SettingsSyncAdapter.kt
│   │   │   ├── WallpaperSyncAdapter.kt
│   │   │   └── BackupSyncAdapter.kt
│   │   └── providers/                              // Implementations for different sync providers (e.g., cloud)
│   │       ├── CloudSyncProvider.kt
│   │       └── LocalBackupProvider.kt
│   └── build.gradle.kts
├── shared/                                         // Shared modules: Cross-cutting concerns and external integrations
│   ├── analytics/                                  // Analytics and crash reporting
│   │   ├── src/main/java/com/launcher/shared/analytics/
│   │   │   ├── AnalyticsManager.kt                 // Manages analytics providers
│   │   │   ├── EventTracker.kt                     // Interface for tracking events
│   │   │   ├── events/                             // Defines various analytics events
│   │   │   │   ├── LauncherEvents.kt
│   │   │   │   ├── AppEvents.kt
│   │   │   │   ├── UserEvents.kt
│   │   │   │   └── PerformanceEvents.kt
│   │   │   └── providers/                          // Implementations for different analytics services
│   │   │       ├── FirebaseAnalytics.kt
│   │   │       ├── CrashlyticsProvider.kt
│   │   │       └── LocalAnalytics.kt
│   │   └── build.gradle.kts
│   ├── cache/                                      // Generic caching mechanisms
│   │   ├── src/main/java/com/launcher/shared/cache/
│   │   │   ├── CacheManager.kt                     // Central cache management
│   │   │   ├── IconCache.kt                        // Specific cache for app icons
│   │   │   ├── WallpaperCache.kt                   // Specific cache for wallpapers
│   │   │   ├── memory/                             // In-memory caching implementations
│   │   │   │   ├── LruCache.kt
│   │   │   │   └── MemoryCache.kt
│   │   │   └── disk/                               // Disk caching implementations
│   │   │       ├── DiskCache.kt
│   │   │       └── ImageDiskCache.kt
│   │   └── build.gradle.kts
│   ├── permissions/                                // Runtime permission management
│   │   ├── src/main/java/com/launcher/shared/permissions/
│   │   │   ├── PermissionManager.kt                // Manages permission requests and results
│   │   │   ├── PermissionChecker.kt                // Utility for checking permission status
│   │   │   ├── models/                             // Models for permissions
│   │   │   │   ├── Permission.kt
│   │   │   │   └── PermissionResult.kt
│   │   │   └── handlers/                           // Specific handlers for different permission types
│   │   │       ├── StoragePermissionHandler.kt
│   │   │       ├── ContactsPermissionHandler.kt
│   │   │       └── LocationPermissionHandler.kt
│   │   └── build.gradle.kts
│   ├── system/                                     // Android system integration and services
│   │   ├── src/main/java/com/launcher/shared/system/
│   │   │   ├── SystemManager.kt                    // High-level system interaction manager
│   │   │   ├── PackageManager.kt                   // Wrapper for Android PackageManager
│   │   │   ├── WallpaperManager.kt                 // Wrapper for Android WallpaperManager
│   │   │   ├── AppWidgetManager.kt                 // Wrapper for Android AppWidgetManager
│   │   │   ├── receivers/                          // Broadcast Receivers for system events
│   │   │   │   ├── PackageChangeReceiver.kt
│   │   │   │   ├── WallpaperChangeReceiver.kt
│   │   │   │   └── TimeChangeReceiver.kt
│   │   │   ├── services/                           // Android Services (e.g., for background tasks, live wallpapers)
│   │   │   │   ├── LauncherService.kt
│   │   │   │   ├── WallpaperService.kt
│   │   │   │   └── WidgetService.kt
│   │   │   └── observers/                          // Content Observers or lifecycle observers for system changes
│   │   │       ├── AppInstallObserver.kt
│   │   │       ├── WallpaperObserver.kt
│   │   │       └── SettingsObserver.kt
│   │   └── build.gradle.kts
│   └── testing/                                    // Testing utilities and fakes for all modules
│       ├── src/main/java/com/launcher/shared/testing/
│       │   ├── TestConstants.kt
│   │   │   ├── TestData.kt
│   │   │   ├── fakes/                              // Fake implementations for testing dependencies
│   │   │   │   ├── FakeRepository.kt
│   │   │   │   ├── FakeDataSource.kt
│   │   │   │   └── FakeSystemManager.kt
│   │   │   ├── rules/                              // JUnit Test Rules for common test setups
│   │   │   │   ├── DatabaseRule.kt
│   │   │   │   ├── CoroutineRule.kt
│   │   │   │   └── CompositionRule.kt
│   │   │   └── matchers/                           // Custom Espresso/Compose matchers
│   │   │       ├── ViewMatchers.kt
│   │   │       └── ComposeMatchers.kt
│   │   └── build.gradle.kts
├── build-logic/                                    // Build Logic module: Centralized Gradle convention plugins
│   ├── build.gradle.kts                            // Gradle build script for the build-logic module itself
│   └── src/main/kotlin/                            // Source for convention plugins (Kotlin DSL)
│       ├── com.launcher.android.application.gradle.kts // Plugin for Android application modules
│       ├── com.launcher.android.library.gradle.kts     // Plugin for Android library modules
│       ├── com.launcher.kotlin.library.gradle.kts      // Plugin for pure Kotlin library modules
│       └── com.launcher.android.compose.gradle.kts     // Plugin for Android modules using Jetpack Compose
├── gradle/                                         // Gradle wrapper and configuration files
│   ├── wrapper/
│   │   ├── gradle-wrapper.jar
│   │   └── gradle-wrapper.properties
│   └── libs.versions.toml                          // Centralized dependency versions
├── build.gradle.kts                                // Root project Gradle build script
├── settings.gradle.kts                             // Gradle settings for multi-module project
├── gradle.properties                               // Global Gradle properties
└── README.md                                       // Project README

```
## Architecture Layers Breakdown

This file structure meticulously implements a **multi-module Clean Architecture** with **MVVM** within each feature.

### 1. Presentation Layer (UI & ViewModel)
* **`app/MainActivity.kt`**: The single entry point for the UI, hosting the Jetpack Compose navigation.
* **`features/*/presentation/`**: Each feature module contains its `ViewModel`, `State`, `Event` definitions, and `components` (Jetpack Compose UI elements) that directly interact with the user and observe data from the ViewModel. The `navigation` sub-package handles feature-specific navigation routes.
* **`core/ui/`**: Contains shared UI components, themes, and animations that can be reused across all feature modules, ensuring a consistent look and feel.

### 2. Domain Layer
* **`features/*/domain/`**: Each feature module has its own `domain` package.
    * **`models/`**: Defines the core business entities (pure Kotlin data classes) that represent the application's state and data, independent of any specific UI or data source implementation.
    * **`usecases/`**: Encapsulates specific business rules and operations. Each Use Case performs a single, well-defined task, orchestrating data flow between the Presentation and Data layers via the Repository interface.
    * **`repository/`**: Contains interfaces that define the contracts for data operations. These interfaces are part of the Domain Layer, ensuring the Domain Layer is independent of *how* data is fetched or stored.

### 3. Data Layer
* **`features/*/data/`**: Each feature module has its `data` package.
    * **`repository/`**: Contains the concrete implementations of the `Repository` interfaces defined in the Domain Layer. These implementations are responsible for coordinating data from various data sources (local, remote, system).
    * **`datasource/`**: Contains the actual implementations for interacting with specific data sources:
        * **`core/database/`**: Handles Room database operations (local data source).
        * **`core/datastore/`**: Manages preferences using Jetpack DataStore (local data source).
        * **`core/network/`**: Manages API calls and network connectivity (remote data source).
        * **`shared/system/`**: Provides data from Android system services (e.g., `SystemAppsDataSource`, `SystemWallpaperDataSource`, `SystemWidgetsDataSource`, `ContactsDataSource`, `SystemShortcutsDataSource`).
    * **`mappers/`**: Responsible for converting data between network/database entities and domain models, ensuring the Domain Layer remains clean and independent.

### 4. Shared/Core Layer
* **`core/common/`**: Provides fundamental building blocks like `BaseActivity`, `BaseViewModel`, common utilities (`Logger`, `StringUtils`), Kotlin extensions, and generic models (`Result`, `Resource`, `UiState`) that are used across all layers and modules.
* **`shared/`**: Contains cross-cutting concerns that are not tied to specific features but provide common services or integrations:
    * **`analytics/`**: Centralized analytics and crash reporting.
    * **`cache/`**: Generic caching mechanisms for various data types.
    * **`permissions/`**: Standardized way to handle Android runtime permissions.
    * **`system/`**: Wrappers and managers for interacting with various Android system services and receiving system broadcasts.
    * **`testing/`**: Provides utilities, fakes, and rules to facilitate robust testing across the entire application.

### 5. Top-Level Modules
* **`performance/`**: A dedicated top-level module for performance monitoring, benchmarking, and collecting metrics (e.g., startup time, frame rates, memory usage). This module will integrate with Android's Macrobenchmark and Microbenchmark tools to ensure the application meets performance targets.
* **`sync/`**: A dedicated top-level module responsible for all data synchronization logic. This includes scheduling sync operations (e.g., using WorkManager), managing sync configurations, handling sync results, and integrating with various sync providers (e.g., cloud backup services, local device sync mechanisms).

## Key Architectural Patterns

### Modular Architecture
The project is divided into `app`, `core`, `features`, `shared`, `performance`, `sync`, and `build-logic` modules.
* `app`: Orchestrates the application.
* `core`: Contains fundamental, reusable components that are often Android-independent or provide basic Android wrappers.
* `features`: Encapsulates independent business functionalities, promoting feature development in isolation.
* `shared`: Handles cross-cutting concerns and external integrations that are not core to specific features or top-level concerns.
* **`performance`**: Manages all aspects of application performance testing and monitoring.
* **`sync`**: Manages all aspects of data synchronization.
* **`build-logic`**: Centralizes and abstracts Gradle build configurations, promoting consistency and maintainability across all modules.

This modularity enhances:
* **Scalability**: New features and cross-cutting concerns can be added as new modules.
* **Reusability**: Core, shared, performance, and sync components are easily reused.
* **Build Times**: Incremental builds are faster.
* **Team Collaboration**: Different teams can work on different features/modules simultaneously with clear boundaries.

### MVVM Pattern (within each feature)
```kotlin
// Example structure for HomeScreen
HomeScreenViewModel (features/homescreen/presentation)
    ↓ (observes/calls)
GetHomeScreenItemsUseCase (features/homescreen/domain)
    ↓ (calls)
HomeScreenRepository (features/homescreen/domain/repository - Interface)
    ↓ (implemented by)
HomeScreenRepositoryImpl (features/homescreen/data/repository - Implementation)
    ↓ (uses)
HomeScreenLocalDataSource (features/homescreen/data/datasource)
HomeScreenRemoteDataSource (features/homescreen/data/datasource)
SystemAppsDataSource (shared/system/datasource - if applicable)
```

### Dependency Injection (DI)
* **`app/di/`**: Contains Hilt modules (`AppModule`, `DatabaseModule`, `RepositoryModule`, `ViewModelModule`) that define how dependencies are provided throughout the application. This ensures loose coupling and enhances testability.

This architecture provides a clear, scalable, and testable foundation for a complex Android Launcher application, adhering to modern Android development best practices.
