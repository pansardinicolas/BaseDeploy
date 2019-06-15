package teste.nicolas.basedeploy.model.datasource

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import teste.nicolas.basedeploy.model.data.dto.remote.MovieDetailResponse
import teste.nicolas.basedeploy.model.data.dto.remote.UpcomingMovieResponse

interface MovieDatabaseApi {

    @GET("movies/get-upcoming")
    fun getUpcomingMovies() : Deferred<List<UpcomingMovieResponse>>

    @GET("movies/get-movie-details/{movieId}")
    fun getMovieDetails(@Path("movieId") movieId: Int) : Deferred<MovieDetailResponse>
}