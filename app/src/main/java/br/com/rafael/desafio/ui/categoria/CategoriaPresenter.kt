package br.com.rafael.desafio.ui.categoria

import br.com.rafael.desafio.base.BasePresenter
import br.com.rafael.desafio.repository.rest.ChuckNorrisApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CategoriaPresenter(baseView: CategoriaView) : BasePresenter<CategoriaView>(baseView) {


    @Inject
    lateinit var chuckNorrisApi: ChuckNorrisApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        super.onViewCreated()
        loadCategoria()
    }


    fun loadCategoria() {
        view.showLoading()
        subscription = chuckNorrisApi
                .getCategoria()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { it -> view.update(it) },
                        {
                            it.printStackTrace()
                        })
    }


    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription?.dispose()
    }

}