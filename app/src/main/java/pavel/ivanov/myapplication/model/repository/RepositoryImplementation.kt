package pavel.ivanov.myapplication.model.repository

import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    // Репозиторий возвращает данные, используя dataSource (локальный или внешний)
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
