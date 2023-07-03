package com.example.myapplication

class PersonRepo {

    fun getAllData():List<Person>{
        return listOf(
            Person(1,"A","B",20),
            Person(2,"C","D",21),
            Person(3,"E","F",22),
            Person(4,"G","H",23),
            Person(5,"I","J",24),
            Person(6,"K","L",25),
            Person(7,"M","N",26),
            Person(8,"O","P",27),
            Person(9,"Q","R",28),
            Person(10,"S","T",29),
            Person(11,"U","V",30),
        )
    }
}