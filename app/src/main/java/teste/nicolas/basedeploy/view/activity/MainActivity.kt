package teste.nicolas.basedeploy.view.activity

import android.os.Bundle
import dagger.android.DaggerActivity
import teste.nicolas.basedeploy.R
import teste.nicolas.basedeploy.databinding.ActivityMainBinding
import teste.nicolas.basedeploy.viewmodel.UpcomingMoviesViewModel
import teste.nicolas.basedeploy.viewmodel.adapter.UpcomingMoviesAdapter
import javax.inject.Inject

class MainActivity : DaggerActivity() {

    @Inject
    lateinit var upcomingMoviesViewModel: UpcomingMoviesViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setUI()
    }

    private fun setUI() {
        binding.viewModel = upcomingMoviesViewModel
        binding.recyclerView.adapter = UpcomingMoviesAdapter(emptyList())
    }

}
