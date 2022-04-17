package pavel.ivanov.repository

import pavel.ivanov.model.data.AppState
import pavel.ivanov.model.data.DataModel
import pavel.ivanov.model.data.dto.SearchResultDto
import pavel.ivanov.repository.room.HistoryDao

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}

