package pavel.ivanov.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import pavel.ivanov.myapplication.model.data.AppState

abstract class BaseViewModel<T : AppState>(
    protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData()
) : ViewModel() {

/*
    Объявляем свой собственный скоуп.
    В качестве аргумента передается CoroutineContext, который мы составляем через "+" из трех частей:
    - Dispatchers.Main говорит, что результат работы предназначен для основного потока;
    - SupervisorJob() позволяет всем дочерним корутинам выполнятьсянезависимо,
        то есть, если какая-то корутина упадёт с ошибкой, остальныебудут выполнены нормально;
    - CoroutineExceptionHandler позволяет перехватывать и отрабатыватьошибки и краши
*/
protected val viewModelCoroutineScope = CoroutineScope(
    Dispatchers.Main
            + SupervisorJob()
            + CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    })


    // Метод, благодаря которому Activity подписывается на изменение данных, возвращает LiveData, через которую и передаются данные
    abstract fun getData(word: String, isOnline: Boolean)
    // обрабатываем ошибки в конкретной имплементации базовой ВьюМодели
    abstract fun handleError(error: Throwable)

    // Единственный метод класса ViewModel, который вызывается перед уничтожением Activity
    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    // Завершаем все незавершённые корутины, потому что пользователь закрыл экран
    protected fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }
}
