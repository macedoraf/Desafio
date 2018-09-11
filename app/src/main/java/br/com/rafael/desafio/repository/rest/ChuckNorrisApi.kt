package br.com.rafael.desafio.repository.rest

import br.com.rafael.desafio.model.Categoria
import br.com.rafael.desafio.model.Joke
import dagger.Component
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface ChuckNorrisApi {


    @GET("/jokes/categories")
    fun getCategoria(): Observable<List<String>>

    @GET("/jokes/random?category={categoria}")
    fun getJoke(@Path("categoria") categoria: String): Observable<Joke>
}