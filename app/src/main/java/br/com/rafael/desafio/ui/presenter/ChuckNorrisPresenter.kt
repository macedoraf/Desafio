package br.com.rafael.desafio.ui.presenter

import br.com.rafael.desafio.R
import br.com.rafael.desafio.base.BasePresenter
import br.com.rafael.desafio.rest.ChuckNorrisApi
import br.com.rafael.desafio.ui.view.ChuckNorrisView
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class ChuckNorrisPresenter(baseView: ChuckNorrisView) : BasePresenter<ChuckNorrisView>(baseView) {


    lateinit var chuckNorrisApi: ChuckNorrisApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        super.onViewCreated()
        loadPosts()
    }


    fun loadPosts() {
        view.showLoading()
        subscription = chuckNorrisApi
                .getCategoria()
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