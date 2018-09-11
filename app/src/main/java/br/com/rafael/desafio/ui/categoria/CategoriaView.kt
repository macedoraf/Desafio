package br.com.rafael.desafio.ui.categoria

import android.support.annotation.StringRes
import br.com.rafael.desafio.base.BaseView
import br.com.rafael.desafio.model.Categoria

interface CategoriaView : BaseView {


    fun update(categories: List<String>)

    fun showError()

    fun showError(@StringRes errorResId: Int)

    fun showLoading()

    fun hideLoading()
}