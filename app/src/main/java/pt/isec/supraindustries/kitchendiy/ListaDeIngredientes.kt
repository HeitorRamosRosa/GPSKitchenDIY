package pt.isec.supraindustries.kitchendiy

import android.content.Context

class ListaDeIngredientes(val context: Context) {
    fun getLista(): Array<String> {
        return context.resources.getStringArray(R.array.array_ingredientes)
    }
}