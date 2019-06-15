package teste.nicolas.basedeploy.model.data.dto.remote

data class UpcomingMovieResponse(val id: Int, val title: String, val vote_average: Number, val release_date: String,
                                 var poster_path: String? = null)