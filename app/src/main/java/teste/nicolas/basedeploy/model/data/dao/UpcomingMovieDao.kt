package teste.nicolas.basedeploy.model.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import teste.nicolas.basedeploy.model.data.dto.local.UpcomingMovie

@Dao
interface UpcomingMovieDao {

    @Query("SELECT * FROM upcomingmovie")
    fun getUpcomingMovies(): LiveData<List<UpcomingMovie>>

    @Insert
    fun insertUpcomingMovies(movies: List<UpcomingMovie>)

    @Update
    fun updateUpcomingMovie(movie: UpcomingMovie)

    @Delete
    fun deleteUpcomingMovie(movie: UpcomingMovie)
}