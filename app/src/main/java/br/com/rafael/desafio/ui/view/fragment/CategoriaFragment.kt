package br.com.rafael.desafio.ui.view.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import br.com.rafael.desafio.R
import br.com.rafael.desafio.model.Categoria
import br.com.rafael.desafio.ui.view.ChuckNorrisView

class CategoriaFragment : Fragment(), ChuckNorrisView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_categoria, container, false)
        inicializaControles(view)
        return view
    }

    private fun inicializaControles(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progressBar)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
    }


    override fun getContext(): Context {
        return context
    }

    override fun update(categories: List<Categoria>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {

    }

    override fun showError(errorResId: Int) {
        Toast.makeText(context, "ERRO", Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}