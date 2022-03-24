package pavel.ivanov.myapplication.model.datasource

import io.reactivex.Observable
import pavel.ivanov.myapplication.model.data.DataModel

// Для локальных данных используется Room
class DataSourceLocal(

    private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()

) : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> =
        remoteProvider.getData(word)
}