package pavel.ivanov.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import pavel.ivanov.myapplication.model.data.AppState
import pavel.ivanov.myapplication.rx.SchedulerProvider

abstract class BaseViewModel<T : AppState>(
    // Инстанс LiveData
    protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {

    // Метод, благодаря которому Activity подписывается на изменение данных, возвращает LiveData, через которую и передаются данные
    open fun getData(word: String, isOnline: Boolean): LiveData<T> = liveDataForViewToObserve

    // Единственный метод класса ViewModel, который вызывается перед уничтожением Activity
    override fun onCleared() {
        compositeDisposable.clear()
    }
}
