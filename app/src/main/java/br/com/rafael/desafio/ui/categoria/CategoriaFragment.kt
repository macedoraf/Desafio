package br.com.rafael.desafio.ui.categoria

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import br.com.rafael.desafio.R
import br.com.rafael.desafio.base.BaseFragment
import br.com.rafael.desafio.ui.adapter.CategoriaAdapter

class CategoriaFragment : BaseFragment<CategoriaPresenter>(), CategoriaView, (String) -> Unit {


    override fun invoke(categoria: String) {
        Toast.makeText(this.context, categoria, Toast.LENGTH_SHORT).show()
    }

    private var list: MutableList<String> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_categoria, container, false)
        inicializaControles(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    private fun inicializaControles(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progressBar)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CategoriaAdapter(list, this)
    }


    override fun getContexto(): Context {
        return context!!
    }


    override fun instantiatePresenter(): CategoriaPresenter {
        return CategoriaPresenter(this)
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
        recyclerView.adapter?.notifyDataSetChanged()



    }


    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onViewDestroyed()
    }

    override fun update(categories: List<String>) {
        list.clear()
        list.addAll(categories)
    }
}