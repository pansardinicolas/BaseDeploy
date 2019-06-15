package teste.nicolas.basedeploy.model.repository

import kotlinx.coroutines.Deferred
import teste.nicolas.basedeploy.model.data.dto.remote.MovieDetailResponse
import teste.nicolas.basedeploy.model.data.dto.remote.UpcomingMovieResponse

interface MovieRepository {

    suspend fun getUpcomingMovies() : Deferred<List<UpcomingMovieResponse>>

    suspend fun getMovieDetails(movieId: Int) : Deferred<MovieDetailResponse>

}