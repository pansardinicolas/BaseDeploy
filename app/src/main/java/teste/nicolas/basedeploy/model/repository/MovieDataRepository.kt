package teste.nicolas.basedeploy.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import teste.nicolas.basedeploy.model.data.dao.AppDatabase
import teste.nicolas.basedeploy.model.data.dto.local.UpcomingMovie
import teste.nicolas.basedeploy.model.data.dto.remote.MovieDetailResponse
import teste.nicolas.basedeploy.model.data.dto.remote.UpcomingMovieResponse
import java.io.IOException
import javax.inject.Inject

class MovieDataRepository() : MovieRepository, BaseRepository() {

    @Inject
    lateinit var db: AppDatabase
    @Inject
    lateinit var api: Repository

    private suspend fun getUpcomingMoviesFromRepo() = withContext(IO) {
        async {
            try {
                val result = api.getDataFromApi().getUpcomingMovies().await()
                if (result.isSuccessful) {
                    result.body()?.let { db.upcomingMovieDao().insertUpcomingMovies(it) }
                } else {
                    Log.e("UpcomingMovie", result.errorBody().toString())
                }
            } catch (exception: IOException) {
                Log.e("UpcomingMovie", "Error fetching upcoming movie", exception)
            }
        }
    }

    private suspend fun getMovieDetailsFromRepo(movieId: Int) = withContext(IO) {
        async { api.getDataFromApi().getMovieDetails(movieId).await() }
    }

    override suspend fun getUpcomingMovies(): LiveData<List<UpcomingMovieResponse>> {
        GlobalScope.launch {
            getUpcomingMoviesFromRepo().await();
        }
        return transformFromDaoToResponse(db.upcomingMovieDao().getUpcomingMovies())
    }

    override suspend fun getMovieDetails(movieId: Int): LiveData<MovieDetailResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun transformFromDaoToResponse(upcomingMovies: LiveData<List<UpcomingMovie>>): LiveData<List<UpcomingMovieResponse>> {
        var list = mutableListOf<UpcomingMovieResponse>()
        val it = upcomingMovies.value
        if (it != null) {
            for (movie in it) {
                val res = UpcomingMovieResponse.Success(movie ?: UpcomingMovie())
                list.add(res)
            }
        }
        val movieResponses = MutableLiveData<List<UpcomingMovieResponse>>()
        movieResponses.value = list
        return movieResponses
    }

    /*
{
            var upcomingMovies: MutableList<UpcomingMovieResponse>? = null
            val upcomingMovieRequest = api.getDataFromApi().getUpcomingMovies()

            try {
                val response = upcomingMovieRequest.await()
                if (response.isSuccessful) {
                    val movieResponse = response.body()
                    upcomingMovies = movieResponse?.toMutableList()
                } else {
                    Log.d("FetchMovie", response.errorBody().toString())
                }
            } catch (e: Exception) {
                Log.d("FetchMovie", e.message.toString())
            }
            return@async upcomingMovies
 */

}