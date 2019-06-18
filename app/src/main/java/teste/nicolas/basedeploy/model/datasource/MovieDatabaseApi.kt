package teste.nicolas.basedeploy.model.datasource

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import teste.nicolas.basedeploy.model.data.dto.local.UpcomingMovie
import teste.nicolas.basedeploy.model.data.dto.remote.MovieDetailResponse

interface MovieDatabaseApi {

    @GET("movies/get-upcoming")
    suspend fun getUpcomingMovies(): Deferred<Response<List<UpcomingMovie>>>

    @GET("movies/get-movie-details/{movieId}")
    fun getMovieDetails(@Path("movieId") movieId: Int) : Deferred<MovieDetailResponse>
}