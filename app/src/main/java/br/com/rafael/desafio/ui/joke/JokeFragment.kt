package br.com.rafael.desafio.ui.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import br.com.rafael.desafio.R
import br.com.rafael.desafio.base.BaseFragment
import br.com.rafael.desafio.model.Joke

class JokeFragment : BaseFragment<JokePresenter>(), JokeView {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_joke, container, false)
        return view
    }

    private lateinit var progressBar: ProgressBar


    override fun instantiatePresenter(): JokePresenter {
        return JokePresenter(this)
    }

    override fun update(joke: Joke) {
    }

    override fun showError() {
        Toast.makeText(getContexto(), "Erro", Toast.LENGTH_LONG).show()
    }

    override fun showError(errorResId: Int) {

    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }


}