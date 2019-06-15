package teste.nicolas.basedeploy.model.data.dto

data class MovieDetailResponse(val id: Int, var backdrop_path: String? = null, val genres: List<GenreDTO>, val title: String, var overview: String? = null,
                               val vote_average: Number, val runtime: Int? = null, val releaseDate: String, val budget: Int, val revenue: Int)