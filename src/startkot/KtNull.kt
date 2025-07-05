package startkot

import domain.Student

class KtNull {
    fun test(){
        val student = Student(1, "kun", 5, "남성")
        val name = student.name
        val age = student.age
        student.age = 10
    }
}