package com.example.masterdetail.dummy

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

    /**
     * inicialización del singleton
     */
    init {
        // En este paso necesitamos añadir los posts.
        // TODO hacer la peticion doAsync, traer el json y parsearlo
    }

    /**
     * Añadimos los posts al arraylist y los metemos en el hashmap tambien
     * @param item objeto con el contenido del post
     */
    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    /**
     * Esta clase la utilizamos para almacenar los posts
     * En el constructor le pasamos el id, titulo y resumen
     */
    data class DummyItem(val id: String, val title: String, val resumen: String) {
        // personalizamos toString para que nos devuelva el titulo
        override fun toString(): String = title
    }
}
