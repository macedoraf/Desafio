package br.com.rafael.desafio.ui.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.rafael.desafio.R

class CategoriaAdapter(val listCategoria: List<String>,
                       val onClick: (String) -> Unit) : RecyclerView.Adapter<CategoriaAdapter.CategoriaHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder = CategoriaHolder(LayoutInflater.from(parent.context).inflate(R.layout.lst_categoria, parent, false))


    override fun getItemCount(): Int = listCategoria.size


    override fun onBindViewHolder(holder: CategoriaHolder, position: Int) {
        holder.bind(listCategoria[position])
        holder.setOnClickListener(onClick)
    }


    class CategoriaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var string: String

        fun bind(descricao: String) {
            itemView.findViewById<TextView>(R.id.descricao).text = descricao
            string = descricao
        }

        fun setOnClickListener(onClick: (String) -> Unit) {
            itemView.findViewById<CardView>(R.id.cardview).setOnClickListener {
                onClick(string)
            }

        }


    }
}