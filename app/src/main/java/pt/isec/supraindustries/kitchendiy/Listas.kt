package pt.isec.supraindustries.kitchendiy

import android.content.Context

class Listas(val context: Context) {
    fun getListaIngredientes(): Array<String> {
        return context.resources.getStringArray(R.array.array_ingredientes)
    }
    fun getListaReceitas(): Array<String> {
        return context.resources.getStringArray(R.array.array_receitas)
    }
}