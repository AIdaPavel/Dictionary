package pavel.ivanov.myapplication.model.datasource

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.data.api.ApiService
import pavel.ivanov.myapplication.model.data.api.BaseInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return getService(BaseInterceptor.interceptor).searchAsync(word).await()
    }

    private fun getService(interceptor: Interceptor): ApiService {
        return createRetrofit(interceptor).create(ApiService::class.java)
    }

    /*Обратите внимание на Builder: в addCallAdapterFactory теперь передаётся
    CoroutineCallAdapterFactory() которая позволяет Retrofit работать с корутинами.
    Для ее использования нужно прописать для Ретрофита зависимость
    вместо той, которая была для Rx: implementation*/
    private fun createRetrofit(interceptor: Interceptor): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_LOCATIONS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(createOkHttpClient(interceptor))
            .build()
    }

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        return httpClient.build()
    }

    companion object {
        private const val BASE_URL_LOCATIONS =
            "https://dictionary.skyeng.ru/api/public/v1/"
    }
}
