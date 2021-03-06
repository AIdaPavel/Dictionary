package pavel.ivanov.myapplication.model.data.api

import kotlinx.coroutines.Deferred
import pavel.ivanov.myapplication.model.data.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<DataModel>>
}
