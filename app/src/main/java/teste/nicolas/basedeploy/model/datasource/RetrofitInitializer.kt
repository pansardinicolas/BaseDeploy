package teste.nicolas.basedeploy.model.datasource

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInitializer() {
    fun init() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(createClientInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClientInterceptor(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .header("Authorization", "1f54bd990f1cdfb230adb312546d765d")

            val request = requestBuilder.build()
            chain.proceed(request)
        }


        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)

        return httpClient.build()
    }
}