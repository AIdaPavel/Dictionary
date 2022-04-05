package pavel.ivanov.myapplication.model.datasource

import pavel.ivanov.myapplication.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") // Заполнить
    }
}
