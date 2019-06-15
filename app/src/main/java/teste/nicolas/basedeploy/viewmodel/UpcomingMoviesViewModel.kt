package teste.nicolas.basedeploy.viewmodel

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import teste.nicolas.basedeploy.model.datasource.MovieDatabaseApi
import teste.nicolas.basedeploy.viewmodel.di.BaseViewModel
import javax.inject.Inject

class UpcomingMoviesViewModel: BaseViewModel(){
    @Inject
    lateinit var movieApi: MovieDatabaseApi

    private lateinit var subscription: Disposable

    init{
        //loadMovies()
    }

    //In case I was using ReactiveX
/*
    private fun loadMovies(){
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