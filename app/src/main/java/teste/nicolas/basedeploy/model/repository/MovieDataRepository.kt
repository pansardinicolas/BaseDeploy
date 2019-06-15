package teste.nicolas.basedeploy.model.repository

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import teste.nicolas.basedeploy.model.data.dto.remote.MovieDetailResponse
import teste.nicolas.basedeploy.model.data.dto.remote.UpcomingMovieResponse

class MovieDataRepository() : MovieRepository {

    override suspend fun getUpcomingMovies(): Deferred<List<UpcomingMovieResponse>> = withContext(IO){
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMovieDetails(movieId: Int): Deferred<MovieDetailResponse> = withContext(IO){
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}