package teste.nicolas.basedeploy.model.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import teste.nicolas.basedeploy.model.data.dto.local.UpcomingMovie

@Database(entities = arrayOf(UpcomingMovie::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun upcomingMovieDao(): UpcomingMovieDao
}