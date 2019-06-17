package teste.nicolas.basedeploy.model.repository

import androidx.lifecycle.LiveData
import teste.nicolas.basedeploy.model.data.dto.remote.MovieDetailResponse
import teste.nicolas.basedeploy.model.data.dto.remote.UpcomingMovieResponse

interface MovieRepository {

    suspend fun getUpcomingMovies(): LiveData<List<UpcomingMovieResponse>>

    suspend fun getMovieDetails(movieId: Int): LiveData<MovieDetailResponse>

}