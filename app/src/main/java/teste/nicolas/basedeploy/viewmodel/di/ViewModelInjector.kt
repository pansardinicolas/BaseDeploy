package teste.nicolas.basedeploy.viewmodel.di

import dagger.Component
import teste.nicolas.basedeploy.model.RetrofitInitializer
import teste.nicolas.basedeploy.viewmodel.UpcomingMoviesViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(RetrofitInitializer::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified UpcomingMoviesViewModel.
     * @param upcomingMoviesViewModel UpcomingMoviesViewModel in which to inject the dependencies
     */
    fun inject(upcomingMoviesViewModel: UpcomingMoviesViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: RetrofitInitializer): Builder

    }
}