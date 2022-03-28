package pavel.ivanov.myapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pavel.ivanov.myapplication.view.main.MainActivity


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
