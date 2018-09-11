package br.com.rafael.desafio.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment<P : BasePresenter<BaseView>> : Fragment(), BaseView {

    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()

    }


    protected abstract fun instantiatePresenter(): P

    override fun getContexto(): Context {
        return context!!
    }

}