package br.com.rafael.desafio.ui.view

import android.support.annotation.StringRes
import br.com.rafael.desafio.model.Categoria

interface ChuckNorrisView : BaseView {


    fun update(categories: List<Categoria>)

    fun showError()

    fun showError(@StringRes errorResId: Int)

    fun showLoading()

    fun hideLoading()
}