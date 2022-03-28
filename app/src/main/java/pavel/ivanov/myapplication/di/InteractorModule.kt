package pavel.ivanov.myapplication.di

import dagger.Module
import dagger.Provides
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.repository.Repository
import pavel.ivanov.myapplication.view.main.MainInteractor
import javax.inject.Named


@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
