package pt.isec.supraindustries.kitchendiy

class DataHandler {

    companion object{
        var lista :  ArrayList<Int> = ArrayList()

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
    }
}