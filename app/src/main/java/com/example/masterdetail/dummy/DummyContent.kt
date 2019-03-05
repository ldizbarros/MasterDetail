package com.example.masterdetail.dummy

import android.util.Log
import org.jetbrains.anko.doAsync
import org.json.JSONArray
import java.net.URL
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample TITLE for user interfaces created by
 * Android template wizards.
 *
 * https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations
 * Esta es la manera de kotlin de declarar un singleton
 */
object DummyContent {

    /**
     * El array de los posts.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * Un hash map para los posts identificado por los IDs
     * ¿Que es un HashMap? https://www.todoexpertos.com/categorias/tecnologia-e-internet/programacion/java/respuestas/y15actdgfmyx6/explicacion-de-como-se-utiliza-hashmap
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    // ya no hace falta
    // era para construir la lista de items
    // private val COUNT = 25
    val LOGTAG = "SEGUIMIENTO"

    /**
     * inicialización del singleton
     * No necesitamos inicializar nada aqui, lo hacemos en la Activity
     */
    init {
    }

    /**
     * La dejamos publica para poder acceder desde la Activity
     * Añadimos los posts al arraylist y los metemos en el hashmap tambien
     * @param item objeto con el contenido del post
     */
    fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }
}
