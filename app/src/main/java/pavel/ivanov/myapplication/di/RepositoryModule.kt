package pavel.ivanov.myapplication.di

import dagger.Module
import dagger.Provides
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.datasource.DataSource
import pavel.ivanov.myapplication.model.datasource.RetrofitImplementation
import pavel.ivanov.myapplication.model.datasource.RoomDataBaseImplementation
import pavel.ivanov.myapplication.model.repository.Repository
import pavel.ivanov.myapplication.model.repository.RepositoryImplementation
import javax.inject.Named
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImplementation(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> =
        RetrofitImplementation()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> = RoomDataBaseImplementation()
}
