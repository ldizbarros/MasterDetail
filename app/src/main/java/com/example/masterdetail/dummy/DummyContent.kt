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
     */
    init {
        // En este paso necesitamos añadir los posts.
        doAsync {
            // capturamos los errores de la peticion
            try {
                // peticion a un servidor rest que devuelve un json generico
                val respuesta = URL("http://18.191.248.177/wp5/?rest_route=/wp/v2/posts/").readText()
                // parsing data
                //val respuesta = URL("https://jsonplaceholder.typicode.com/posts").readText()
                // parsing data
                // sabemos que recibimos un array de objetos JSON
                val miJSONArray = JSONArray(respuesta)
                // recorremos el Array
                for (jsonIndex in 0..(miJSONArray.length() - 1)) {
                    // asignamos el valor de 'title' en el constructor de la data class 'DummyItem'
                    val idpost = miJSONArray.getJSONObject(jsonIndex).getString("id")
                    val titulo = miJSONArray.getJSONObject(jsonIndex).getString("title")
                    //val resumen = miJSONArray.getJSONObject(jsonIndex).getString("body")
                    val resumen = miJSONArray.getJSONObject(jsonIndex).getString("content")
                    addItem(DummyItem(idpost, titulo, resumen))
                }
                Log.d(LOGTAG, "Peticion terminada")
            } catch (e: Exception) { // Si algo va mal lo capturamos
                Log.d(LOGTAG, "Algo va mal: $e")
            }
        }
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
