package pavel.ivanov.myapplication.model.data

// Состояние приложения
sealed class AppState {

    // Успешно
    data class Success(val data: List<DataModel>?): AppState()

    // Ошибка
    data class Error(val error: Throwable): AppState()

    // Загрузка
    data class Loading(val progress: Int?): AppState()
}
