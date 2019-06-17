package teste.nicolas.basedeploy.model.data.dto.remote

import teste.nicolas.basedeploy.model.data.dto.local.UpcomingMovie

sealed class UpcomingMovieResponse {

    internal data class Success(val movie: UpcomingMovie) : UpcomingMovieResponse()

    internal data class Error(val error: String) : UpcomingMovieResponse()
}