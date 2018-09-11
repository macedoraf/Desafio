package br.com.rafael.desafio.injection.module

import android.content.Context
import android.view.View
import br.com.rafael.desafio.ChuckNorrisApplication
import dagger.Module
import dagger.Provides

@Module
@Suppress("unused")
object ContextModule {


    @JvmStatic
    @Provides
    internal fun provideContext(view: View): Context {
        return view.context
    }


    internal fun provideApplication(context: Context): ChuckNorrisApplication {
        return context.applicationContext as ChuckNorrisApplication
    }
}