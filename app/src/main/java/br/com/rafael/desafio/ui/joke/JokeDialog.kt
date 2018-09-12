package br.com.rafael.desafio.ui.joke

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import br.com.rafael.desafio.R
import br.com.rafael.desafio.model.Joke
import com.squareup.picasso.Picasso

class JokeDialog : JokeView, DialogFragment() {

    lateinit var progressBar: ProgressBar


    override fun update(joke: Joke) {
        lblJoke.text = joke.value
        lblLink.text = joke.url
        Picasso.get().load(joke.iconUrl).into(imgAvatar)

    }

    override fun showError() {

    }

    override fun showError(errorResId: Int) {

    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE

    }

    override fun getContexto(): Context {
        return context!!
    }

    lateinit var imgAvatar: ImageView
    lateinit var lblJoke: TextView
    lateinit var lblLink: TextView
    private lateinit var jokePresenter: JokePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jokePresenter = JokePresenter(this)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var view = LayoutInflater.from(activity).inflate(R.layout.dialog_joke, null)

        inicializaComponentes(view)


        return AlertDialog.Builder(activity)
                .setTitle("")
                .setView(view)
                .create()
    }

    private fun inicializaComponentes(view: View) {
        imgAvatar = view.findViewById(R.id.imgAvatar)
        lblJoke = view.findViewById(R.id.lblJoke)
        lblLink = view.findViewById(R.id.lblLink)
        progressBar = view.findViewById(R.id.progressBar)
    }

    override fun onStart() {
        super.onStart()
        if (arguments != null)
            jokePresenter.loadJoke(arguments!!.getString("categoria"))
    }


    fun show(manager: FragmentManager) {
        super.show(manager, this.javaClass.simpleName)
    }


    override fun onDestroyView() {
        jokePresenter.onViewDestroyed()
        super.onDestroyView()
    }


}