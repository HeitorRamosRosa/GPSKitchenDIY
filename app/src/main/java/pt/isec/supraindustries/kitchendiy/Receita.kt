package pt.isec.supraindustries.kitchendiy

class Receita(var nome : String, var ingredientes: ArrayList<Ingrediente>, var indicacoes : ArrayList<String>) {

   public fun getInfo(): String{
       var ret : String = String()
       ret += "Nome da receita: "+nome+"\nIngredientes:\n"
       for(i in ingredientes){
           ret+=i.nome+" "+i.quantidade+"\n"
       }
       ret+="Indicações:\n"
       for(i in indicacoes){
           ret+= i.toString()+"\n"
       }
       return ret;
    }


}