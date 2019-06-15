package teste.nicolas.basedeploy.viewmodel.di

import androidx.lifecycle.ViewModel
import teste.nicolas.basedeploy.model.RetrofitInitializer
import teste.nicolas.basedeploy.viewmodel.UpcomingMoviesViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(RetrofitInitializer)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is UpcomingMoviesViewModel -> injector.inject(this)
        }
    }
}