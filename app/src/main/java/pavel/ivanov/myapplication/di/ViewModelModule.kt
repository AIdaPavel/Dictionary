package pavel.ivanov.myapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pavel.ivanov.myapplication.view.main.MainViewModel

/* Модуль послужит источником коллекции ViewModel’ей для фабрики:
    - используем этот модуль для создания ViewModel
    - предоставляем ключ для каждой новой ViewModel при помощи класса ViewModelKey, созданного выше;
    - Activity используем фабрику для создания нужной нам ViewModel */

@Module(includes = [InteractorModule::class])
internal abstract class ViewModelModule {

    // Фабрика
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    // Этот метод просто говорит Dagger’у: помести эту модель в список (map) моделей, используя аннотацию @IntoMap, где в качестве ключа будет класс MainViewModel::class
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel
}