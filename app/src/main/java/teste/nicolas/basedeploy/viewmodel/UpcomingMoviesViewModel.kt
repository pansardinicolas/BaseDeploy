package teste.nicolas.basedeploy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.launch
import teste.nicolas.basedeploy.model.data.dto.remote.MovieDetailResponse
import teste.nicolas.basedeploy.model.data.dto.remote.UpcomingMovieResponse
import teste.nicolas.basedeploy.model.repository.MovieDataRepository

class UpcomingMoviesViewModel(private val repo: MovieDataRepository) : CoroutineViewModel() {

    private val upcomingMovies: MutableLiveData<List<UpcomingMovieResponse>> = MutableLiveData()
    private val movieDetail: MutableLiveData<MovieDetailResponse> = MutableLiveData()
    private val loading: MutableLiveData<Boolean> = MutableLiveData()
    private val error: MutableLiveData<Throwable> = MutableLiveData()

    fun upcomingMovies() = upcomingMovies as LiveData<List<UpcomingMovieResponse>>
    fun movieDetail() = movieDetail as LiveData<MovieDetailResponse>
    fun loading() = loading as LiveData<Boolean>
    fun error() = error as LiveData<Throwable>


    private lateinit var subscription: Disposable

    init{
        loadUpcomingMovies()
    }


    private fun loadUpcomingMovies() {

        jobs add launch {
            loading.value = true
            try {
                upcomingMovies.value = repo.getUpcomingMovies().value
                loading.value = false
            } catch (t: Throwable) {
                upcomingMovies.value = emptyList()
                error.value = t
            } finally {
                loading.value = false
            }
        }
    }

    private fun loadMovieDetail(movieId: Int) {

        jobs add launch {
            loading.value = true
            try {
                movieDetail.value = repo.getMovieDetails(movieId).value
                loading.value = false
            } catch (t: Throwable) {
                upcomingMovies.value = emptyList()
                error.value = t
            } finally {
                loading.value = false
            }
        }
    }

    //In case I was using ReactiveX
/*
    private fun loadUpcomingMovies(){
        subscription = movieApi.getMovieDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveMovieListStart() }
                .doOnTerminate { onRetrieveMovieListFinish() }
                .subscribe(
                        { onRetrieveMovieListSuccess() },
                        { onRetrieveMovieListError() }
                )
    }

    private fun onRetrieveMovieListStart(){

    }

    private fun onRetrieveMovieListFinish(){

    }

    private fun onRetrieveMovieListSuccess(){

    }

    private fun onRetrieveMovieListError(){

    }*/
}