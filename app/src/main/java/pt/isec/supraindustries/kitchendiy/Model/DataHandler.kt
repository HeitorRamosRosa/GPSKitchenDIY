package pt.isec.supraindustries.kitchendiy.Model

import android.content.Context
import java.io.*

class DataHandler {

    companion object{
        var receitas_pt : ArrayList<Receita> = ArrayList()
        var receitas_ing : ArrayList<Receita> = ArrayList()
        var ingredientes_pt : MutableSet<String> = mutableSetOf()     //contem o NOME de todos os ingredientes presentes nas receitas, nao os objetos ingredientes em si, porque os objetos ingrediente contêm dentro de si a informação sobre a quantidade.
        var ingredientes_ing : MutableSet<String> = mutableSetOf()   //A forma mais correta de programar isto seria ter um hashmap nas receitas com (ingrediente, quantidade) para podermos ter aqui um Set de ingredientes.

        fun LoadReceitas(mcontext: Context){
            LoadReceitaByName(mcontext,"pao_com_chourico_pt", "pt")
            LoadReceitaByName(mcontext,"pao_com_chourico_ing", "ing")
            LoadReceitaByName(mcontext,"esparguete_a_bolonhesa_pt", "pt")
            LoadReceitaByName(mcontext,"creme_de_cogumelos_e_legumes_pt", "pt")
            LoadReceitaByName(mcontext,"creme_de_cogumelos_e_legumes_ing", "ing")
            LoadReceitaByName(mcontext,"bolonhesa_de_lentilhas_pt", "pt")
        }

        fun LoadReceitaByName(mcontext : Context, fileName : String, lang: String){
            val Context =  mcontext
            val lang = lang
            var string : String

            //val IS : InputStream = Context.resources.openRawResource(R.raw.bolonhesa_de_lentilhas)
            //o de baixo equivale ao de cima, mas encontrando o resource por string em vez de ir diretamente.
            val IS : InputStream = Context.resources.openRawResource(Context.resources.getIdentifier(fileName,"raw",Context.packageName))

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
                    //System.out.println("[EOF Reached]")

                    val IS2 : InputStream = Context.resources.openRawResource(Context.resources.getIdentifier(fileName,"raw",Context.packageName))
                    val reader2 = BufferedReader(InputStreamReader(IS2))
                    iterator = reader2.lineSequence().iterator()

                    while(iterator.hasNext()){
                        string = iterator.next()
                        if(string.equals("Ingredientes:")){
                            //System.out.println("Extracting ingredientes.")
                            break;
                        }
                    }
                    while(iterator.hasNext() && readMore ){
                        string = iterator.next()
                        if(string.equals("Preparação:")){
                            readMore = false
                            //System.out.println("Extracting Done.")
                            break;
                        }
                        var quantidade = iterator.next()
                        //System.out.println("Extracting: ["+string+"] q:["+quantidade+"]")
                        var temp : Ingrediente = Ingrediente(string, quantidade)
                        listaIngredientes.add(temp)
                    }

                    while(iterator.hasNext()){
                        string = iterator.next()
                        if(string.equals("Preparação:"))
                           //System.out.println("Getting instruções");
                        else
                        {
                            listaInstrucoes.add(string)
                        }
                    }
                    //System.out.println("Got "+listaIngredientes.size+" ingredientes")

                    //System.out.println("Creating and adding receita to receitaList")

                    var tempReceita = Receita(fileName,listaIngredientes, listaInstrucoes)
                    GuardaNovosIngredientes(listaIngredientes, lang)
                    if(lang.equals("pt"))
                        receitas_pt.add(tempReceita)
                    else if(lang.equals("ing"))
                        receitas_ing.add(tempReceita)
                    break;
                }catch(e: IOException)
                {
                    e.printStackTrace()
                }
            }while(true)
        }

        private fun GuardaNovosIngredientes(listaIngredientes: ArrayList<Ingrediente>, lang: String) {
                if(lang.equals("pt"))
                {
                    for(ingrediente in listaIngredientes)
                    {
                        if(!ingredientes_pt.contains(ingrediente.nome))
                            ingredientes_pt.add(ingrediente.nome)
                    }
                }
                else if(lang.equals("ing"))
                {
                    for(ingrediente in listaIngredientes)
                    {
                        if(!ingredientes_ing.contains(ingrediente.nome))
                            ingredientes_ing.add(ingrediente.nome)
                    }
                }
        }

        fun ListaAllReceitasInfo() {
            System.out.println("[RECEITAS PT]: "+ receitas_pt.size)
            for(receita in receitas_pt)
                System.out.println(receita.getInfo())
            System.out.println("[RECEITAS ING] "+ receitas_ing.size)
            for(receita in receitas_ing)
                System.out.println(receita.getInfo())
        }
        fun listaAllIngredientesNome(){
            System.out.println("[INGREDIENTES-PT]: "+ ingredientes_pt.size)
            for(ingrediente in ingredientes_pt)
                System.out.println(ingrediente)
            System.out.println("[INGREDIENTES-ING]: "+ ingredientes_ing.size)
            for(ingrediente in ingredientes_ing)
                System.out.println(ingrediente)
        }

    }

}