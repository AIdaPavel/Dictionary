package pavel.ivanov.myapplication.model.data.api

import io.reactivex.Observable
import pavel.ivanov.myapplication.model.data.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<DataModel>>
}
