package br.com.rafael.desafio.ui.view.acitivity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.rafael.desafio.R
import br.com.rafael.desafio.ui.view.fragment.CategoriaFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(View.inflate(this, R.layout.activity_main, null))

        var beginTransaction = supportFragmentManager.beginTransaction()

        var fragment = CategoriaFragment()

        beginTransaction.replace(R.id.frame, fragment)
        beginTransaction.commit()
    }
}