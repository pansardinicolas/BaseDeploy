package teste.nicolas.basedeploy.viewmodel.di

import dagger.Module
import dagger.Provides
import teste.nicolas.basedeploy.model.repository.MovieDataRepository
import teste.nicolas.basedeploy.viewmodel.UpcomingMoviesViewModel

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: MovieDataRepository) = UpcomingMoviesViewModel(repository)
}