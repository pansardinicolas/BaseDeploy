package teste.nicolas.basedeploy.model.repository

import teste.nicolas.basedeploy.model.datasource.MovieDatabaseApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: MovieDatabaseApi) {

    fun getDataFromApi(): MovieDatabaseApi {
        return apiService
    }

}