package br.com.objectboxtest

import android.content.Context
import br.com.objectboxtest.model.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var boxStore: BoxStore

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .buildDefault()
    }
}