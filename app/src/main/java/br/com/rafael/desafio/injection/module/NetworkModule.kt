package br.com.rafael.desafio.injection.module

import br.com.rafael.desafio.repository.rest.ChuckNorrisApi
import br.com.rafael.desafio.utill.URL_BASE
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@Suppress("unused")
object NetworkModule {

    @Provides
    @JvmStatic
    internal fun provideChucknorrisApi(retrofit: Retrofit): ChuckNorrisApi {
        return retrofit.create(ChuckNorrisApi::class.java)
    }

    @Provides
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}