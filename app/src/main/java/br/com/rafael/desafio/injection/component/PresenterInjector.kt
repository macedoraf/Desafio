package br.com.rafael.desafio.injection.component

import br.com.rafael.desafio.base.BaseView
import br.com.rafael.desafio.injection.module.ContextModule
import br.com.rafael.desafio.injection.module.NetworkModule
import br.com.rafael.desafio.ui.categoria.CategoriaPresenter
import br.com.rafael.desafio.ui.joke.JokePresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class])
interface PresenterInjector {


    fun injectCategoria(presenterT: CategoriaPresenter)
    fun injectJoke(presenterT: JokePresenter)


    @Component.Builder
    interface Builder {

        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder

        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder

    }


}