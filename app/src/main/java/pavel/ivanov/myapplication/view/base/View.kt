package pavel.ivanov.myapplication.view.base

import pavel.ivanov.myapplication.model.data.AppState

// Нижний уровень. View знает о контексте и фреймворке
interface View {

    // View имеет только один метод, в который приходит некое состояние приложения
    fun renderData(appState: AppState)
}