package br.com.rafael.desafio.base

import br.com.rafael.desafio.injection.component.DaggerPresenterInjector
import br.com.rafael.desafio.injection.component.PresenterInjector
import br.com.rafael.desafio.injection.module.ContextModule
import br.com.rafael.desafio.injection.module.NetworkModule
import br.com.rafael.desafio.ui.categoria.CategoriaPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .networkModule(NetworkModule)
            .contextModule(ContextModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}


    private fun inject() {
        when (this) {

            is CategoriaPresenter -> injector.inject(this)
//            is JokePresenter -> injector.inject(this)

        }
    }

}