package teste.nicolas.basedeploy.model.data.dao

import androidx.room.*
import teste.nicolas.basedeploy.model.data.dto.local.UpcomingMovie

@Dao
interface UpcomingMovieDao {

    @Query("SELECT * FROM upcomingmovie")
    suspend fun getUpcomingMovies(): List<UpcomingMovie>

    @Insert
    suspend fun insertUpcomingMovie(movie: UpcomingMovie)

    @Update
    suspend fun updateUpcomingMovie(movie: UpcomingMovie)

    @Delete
    suspend fun deleteUpcomingMovie(movie: UpcomingMovie)
}