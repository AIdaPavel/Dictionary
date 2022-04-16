package pavel.ivanov.myapplication.model.data

import pavel.ivanov.myapplication.model.data.dto.SearchResultDto
import pavel.ivanov.myapplication.model.data.userdata.Meaning
import pavel.ivanov.myapplication.model.data.userdata.TranslatedMeaning

// Состояние приложения
sealed class AppState {
    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}

fun mapSearchResultToResult(searchResults: List<SearchResultDto>):
        List<DataModel> {
    return searchResults.map { searchResult ->
        var meanings: List<Meaning> = listOf()
        searchResult.meanings?.let { // Дополнительная проверка для
// HistoryScreen, так как там сейчас не
// отображаются значения
            meanings = it.map { meaningsDto ->
                Meaning(
                    TranslatedMeaning(
                        meaningsDto?.translation?.translation ?: ""
                    ),
                    meaningsDto?.imageUrl ?: ""
                )
            }
        }
        DataModel(searchResult.text ?: "", meanings)
    }
}


