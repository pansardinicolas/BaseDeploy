package teste.nicolas.basedeploy.model

import android.app.Application
import androidx.room.Room
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import teste.nicolas.basedeploy.model.data.dao.AppDatabase
import teste.nicolas.basedeploy.model.datasource.MovieDatabaseApi
import teste.nicolas.basedeploy.model.repository.MovieDataRepository
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
class RetrofitInitializer {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @Provides
    internal fun provideMovieDatabaseApi(retrofit: Retrofit): MovieDatabaseApi {
        return retrofit.create(MovieDatabaseApi::class.java)
    }

    @Provides
    @Reusable
    internal fun provideRetrofitInterface() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://developers.themoviedb.org/3/")
            .client(createClientInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "room.db").build()


    @Provides
    fun provideRepository(db: AppDatabase, api: MovieDatabaseApi): MovieDataRepository = MovieDataRepository(db, api)

    private fun createClientInterceptor(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", "1f54bd990f1cdfb230adb312546d765d")
                .addQueryParameter("language", "pt-BR")
                .addQueryParameter("region", "BR")
                .build()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)

        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)

        return httpClient.build()
    }
}