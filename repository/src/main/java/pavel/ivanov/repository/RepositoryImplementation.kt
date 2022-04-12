package pavel.ivanov.repository

import pavel.ivanov.model.data.DataModel

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    // Репозиторий возвращает данные, используя dataSource (локальный или внешний)
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
