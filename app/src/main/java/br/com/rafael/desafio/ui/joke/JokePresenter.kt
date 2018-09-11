package br.com.rafael.desafio.ui.joke

import br.com.rafael.desafio.R
import br.com.rafael.desafio.base.BasePresenter
import br.com.rafael.desafio.repository.rest.ChuckNorrisApi
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class JokePresenter(baseView: JokeView) : BasePresenter<JokeView>(baseView) {


    lateinit var chuckNorrisApi: ChuckNorrisApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        super.onViewCreated()
    }


    fun loadJoke(categoria: String) {
        view.showLoading()
        subscription = chuckNorrisApi
                .getJoke(categoria)
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { it -> view.update(it) },
                        { view.showError(R.string.erro) })
    }


    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription?.dispose()
    }

}