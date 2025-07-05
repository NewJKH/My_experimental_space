package startkot

fun main() {
//    val kScore = readLine()!!.toInt()
//    val eScore = readLine()!!.toInt()
//    val mScore = readLine()!!.toInt()
//
//    val avg = (kScore+eScore+mScore)/3;
//    if ( avg > 90 ){
//        println(" = 조건 검사 90점 초과")
//    }else if ( avg > 50 ){
//        println(" = 조건 검사 50점 초과")
//    }else{
//        println(" = 조건 검사 그 아래 ")
//    }

//    var infos = arrayOf("이게 리스트?"," 엄청 간단하네", "자바는 라이브러리 추가했는데 ")
//    for ( info in infos ){
//        println("info = $info")
//    }

//    val value = "12345"
//    println("값 = "+(value+5))
//
//    val it = value.toInt()
//    println("값 = "+(it+5))

//    var t = sum(1,3);
    solution(arrayOf(1,2,3),1)
}
fun sum(va1:Int, va2:Int): Int{
    return va1+va2
}
fun solution(array: IntArray, n: Int): Int {
    var answer = 0

    for ( arr in array ){
        if ( arr == n ){
            answer++
        }
    }

    return answer
}


















