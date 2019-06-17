package teste.nicolas.basedeploy.model.data.dto.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UpcomingMovie(
    @PrimaryKey var id: Int = 0,
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "vote_average") var voteAverage: Long = 0L,
    @ColumnInfo(name = "release_date") var releaseDate: String = "",
    @ColumnInfo(name = "poster_path") var posterPath: String? = null
                         )