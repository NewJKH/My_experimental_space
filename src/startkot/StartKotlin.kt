package startkot

class StartKotlin {
    companion object {
        @JvmStatic
        fun main(n:Int, t:Int):Int {
            var abc = n
            for ( i in 0 .. t){
                abc*=2
            }
            return abc
        }
    }
}