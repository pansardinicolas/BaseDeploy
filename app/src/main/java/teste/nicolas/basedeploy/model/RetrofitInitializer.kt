package teste.nicolas.basedeploy.model

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import teste.nicolas.basedeploy.model.datasource.MovieDatabaseApi
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object RetrofitInitializer {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMovieDatabaseApi(retrofit: Retrofit): MovieDatabaseApi {
        return retrofit.create(MovieDatabaseApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface() : Retrofit{
        return Retrofit.Builder()
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