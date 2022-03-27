package pavel.ivanov.myapplication.presenter

import pavel.ivanov.myapplication.view.base.View
import pavel.ivanov.myapplication.model.data.AppState

// На уровень выше находится презентер, который уже ничего не знает ни о контексте, ни о фреймворке
interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    // Получение данных с флагом isOnline(из Интернета или нет)
    fun getData(word: String, isOnLine: Boolean)
}