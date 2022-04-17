package pavel.ivanov.repository.api

import kotlinx.coroutines.Deferred
import pavel.ivanov.model.data.dto.SearchResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<SearchResultDto>>
}