package br.com.rafael.desafio.repository.rest

import br.com.rafael.desafio.model.Joke
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ChuckNorrisApi {


    @GET("/jokes/categories")
    fun getCategoria(): Observable<List<String>>

    @GET("/jokes/random")
    fun getJoke(@Query("category") categoria: String): Observable<Joke>
}