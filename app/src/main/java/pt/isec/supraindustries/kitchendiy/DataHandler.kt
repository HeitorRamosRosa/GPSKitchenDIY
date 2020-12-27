package pt.isec.supraindustries.kitchendiy

import android.content.Context
import android.os.Environment
import android.util.Log
import kotlinx.android.synthetic.main.activity_receita.*
import java.io.*

class DataHandler {

    companion object{
        var lista :  ArrayList<Int> = ArrayList()
        var receitas : ArrayList<Receita> = ArrayList()

        fun addInt(num: Int){
            lista.add(num)
        }

        fun getNumber(index: Int) : Int{
            if(index>=lista.size)
                return -1
            return lista[index]
        }

        fun getSize() : Int{
            return lista.size
        }

        fun LoadReceitas(mcontext : Context){
            val Context =  mcontext

            var string : String
            val stringBuilder = StringBuilder()
            //val fileContent= DataHandler::class.java.getResource("bolonhesa_de_lentilhas.txt").readText()
            //val IS : InputStream = DataHandler::class.java.getResourceAsStream("bolonhesa_de_lentinhas.txt")

            val IS : InputStream = Context.resources.openRawResource(R.raw.bolonhesa_de_lentilhas)
            val reader = BufferedReader(InputStreamReader(IS))
            do
            {
                var listaIngredientes: ArrayList<Ingrediente> = ArrayList()
                var listaInstrucoes : ArrayList<String> = ArrayList()
                var readMore = true
                try
                {

                    var iterator = reader.lineSequence().iterator()
                    while(iterator.hasNext()){
                        string = iterator.next()
                        System.out.println(string)
                    }
                    System.out.println("[EOF Reached]")

                    val IS2 : InputStream = Context.resources.openRawResource(R.raw.bolonhesa_de_lentilhas)
                    val reader2 = BufferedReader(InputStreamReader(IS2))
                    iterator = reader2.lineSequence().iterator()

                    while(iterator.hasNext()){
                        string = iterator.next()
                        if(string.equals("Ingredientes:")){
                            System.out.println("Extracting ingredientes.")
                            break;
                        }
                    }
                    while(iterator.hasNext() && readMore ){
                        string = iterator.next()
                        if(string.equals("Preparação:")){
                            readMore = false
                            System.out.println("Extracting Done.")
                            break;
                        }
                        var quantidade = iterator.next()
                        System.out.println("Extracting: ["+string+"] q:["+quantidade+"]")
                        var temp : Ingrediente = Ingrediente(string, quantidade)
                        listaIngredientes.add(temp)
                    }

                    while(iterator.hasNext()){
                        string = iterator.next()
                        if(string.equals("Preparação:"))
                            System.out.println("Getting instruções");
                        else
                        {
                            listaInstrucoes.add(string)
                        }
                    }
                    //System.out.println("Got "+listaIngredientes.size+" ingredientes")

                    System.out.println("Creating and adding receita to receitaList")

                    var tempReceita : Receita = Receita("bolonhesa_de_lentilhas",listaIngredientes, listaInstrucoes)
                    receitas.add(tempReceita)
                    break;
                }catch(e: IOException)
                {
                    e.printStackTrace()
                }
            }while(true)
        }

        /*
       fun ler() {
            var string: String? = ""
            val stringBuilder = StringBuilder()
            val `is`: InputStream = this.resources.openRawResource(R.raw.bolonhesa_de_lentilhas)
            val reader = BufferedReader(InputStreamReader(`is`))
            while (true) {
                try {
                    if (reader.readLine().also { string = it } == null) break
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                stringBuilder.append(string).append("\n")
                tv_receita.text = stringBuilder
            }
            `is`.close()
        }
        */


    }

}