package teste.nicolas.basedeploy.viewmodel.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import teste.nicolas.basedeploy.model.RetrofitInitializer
import teste.nicolas.basedeploy.view.activity.AndroidApp

@Component(
    modules = arrayOf(
        AndroidInjectionModule::class, RetrofitInitializer::class,
        ActivityBuilder::class
    )
)
interface AppComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AndroidApp)
}
