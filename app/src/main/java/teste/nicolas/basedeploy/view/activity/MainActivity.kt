package teste.nicolas.basedeploy.view.activity

import android.os.Bundle
import dagger.android.DaggerActivity
import teste.nicolas.basedeploy.R
import teste.nicolas.basedeploy.viewmodel.UpcomingMoviesViewModel
import javax.inject.Inject

class MainActivity : DaggerActivity() {

    @Inject
    lateinit var upcomingMoviesViewModel: UpcomingMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
