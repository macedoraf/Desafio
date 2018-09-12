package br.com.rafael.desafio.ui.joke

import br.com.rafael.desafio.R
import br.com.rafael.desafio.base.BasePresenter
import br.com.rafael.desafio.repository.rest.ChuckNorrisApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class JokePresenter(baseView: JokeView) : BasePresenter<JokeView>(baseView) {


    @Inject
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
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { it -> view.update(it) },
                        {
                            view.showError(R.string.erro)
                            it.printStackTrace()
                        })
    }


    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription?.dispose()
    }

}