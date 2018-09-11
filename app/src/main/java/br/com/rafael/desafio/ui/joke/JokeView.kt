package br.com.rafael.desafio.ui.joke

import android.support.annotation.StringRes
import br.com.rafael.desafio.base.BaseView
import br.com.rafael.desafio.model.Joke

interface JokeView : BaseView {


    fun update(joke: Joke)

    fun showError()

    fun showError(@StringRes errorResId: Int)

    fun showLoading()

    fun hideLoading()
}