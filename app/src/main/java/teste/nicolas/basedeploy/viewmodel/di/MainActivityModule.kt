package teste.nicolas.basedeploy.viewmodel.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import teste.nicolas.basedeploy.model.data.dao.AppDatabase
import teste.nicolas.basedeploy.model.repository.MovieDataRepository
import teste.nicolas.basedeploy.viewmodel.UpcomingMoviesViewModel
import javax.inject.Singleton

@Module
class MainActivityModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "room.db").build()

    @Provides
    fun provideViewModel(repository: MovieDataRepository) = UpcomingMoviesViewModel(repository)
}