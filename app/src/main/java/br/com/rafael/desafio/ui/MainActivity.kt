package br.com.rafael.desafio.ui

import android.os.Bundle
import br.com.rafael.desafio.R
import br.com.rafael.desafio.base.BaseActivity
import br.com.rafael.desafio.ui.categoria.CategoriaFragment

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var beginTransaction = supportFragmentManager.beginTransaction()

        var fragment = CategoriaFragment()

        beginTransaction.replace(R.id.frame, fragment)
        beginTransaction.commit()
    }
}