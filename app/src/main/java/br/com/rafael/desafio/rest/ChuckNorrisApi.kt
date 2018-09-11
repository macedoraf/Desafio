package br.com.rafael.desafio.rest

import br.com.rafael.desafio.model.Categoria
import dagger.Provides
import io.reactivex.Observable
import retrofit2.http.GET


interface ChuckNorrisApi {


    @GET("/jokes/categories")
    fun getCategoria(): Observable<List<Categoria>>
}