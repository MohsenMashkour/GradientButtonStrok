package com.mkrdeveloper.gradientbuttonstrok.data

import com.mkrdeveloper.gradientbuttonstrok.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
   @GET("movies?page=1")
   suspend fun getMoviesData() : Response<MoviesList>
}