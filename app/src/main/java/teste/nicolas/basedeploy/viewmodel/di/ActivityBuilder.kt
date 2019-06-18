package teste.nicolas.basedeploy.viewmodel.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import teste.nicolas.basedeploy.view.activity.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}