package com.rockthejvm

object FunctionalProgramming extends App {
    // class Person(name: String) {
    //     def apply(age: Int) = println(s"I am $age years old")
    // }

    // val bob = new Person("Bob")
    // bob.apply(433)
    // bob(433)  //Invoking bob as a function === bob.apply(433)

    /*
        scala runs on JVM
        functional programming:
        - compose functions
        - pass functions as args
        - return functions as results

        Conclusion: Function X = Function1, Function2, ... Function22
    */

    val simpleIncrementer = new Function1[Int, Int] {
        override def apply(arg: Int): Int = arg + 1
    }

    simpleIncrementer.apply(23)
    println(simpleIncrementer(23)) // === simpleIncrementer.apply(23)
    //defined a function!

    //ALL SCALA Functions are instances of these function_x types

    //function with 2 arguments and a string return type
    val stringConcatenator = new Function2[String, String, String] {
        override def apply(arg1: String, arg2: String): String = arg1 + arg2
    }

    stringConcatenator("I love", "scala")

    // syntax sugars
    val doubler: Function1[Int, Int] = (x: Int) => 2 * x
    //or
    //val doubler: Int => Int = (x: Int) => 2 * x
    //val doubler = (x: Int) => 2 * x

    doubler(4)

    /*
    equivalent to the much longer
    new Function1[Int, Int] {
        override def apply(x: Int) = 2 * x
    }


    */

    //higher-order functions: take functions as args/return functions as results
    val aMappedList = List(1,2,3).map(x => x + 1) // map is higher order function
    println(aMappedList)

    val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2*x)) // conca the list into a big list (1, 2, 2, 4, 3, 6)


    //alternatively
    val aFlatMappedList = List(1,2,3).flatMap {x => 
    List(x, 2*x)} 

    val aFilteredList = List(1,2,3,4,5).filter (x => x <= 3) // filter those smaller or equal 3
    //alternatives:
    val aFilteredList = List(1,2,3,4,5).filter (_ <= 3) 
    

    //chain functions
    // all pairs between the numbers 1, 2, 3 and the letters "a", "b", "c"
    val allPairs = List(1,2,3).flatMap(number => List("a", "b", "c").map(letter => s"$number-$letter"))

    // for comprehensions
    // alternative pair
    val alternativePairs = for {
        number <- List(1,2,3)
        letter <- List("a", "b", "c")
    } yield s"$number-$letter"
    //equivalent to the map/flatmap chain above

    /** Collections */
    val aList = List(1,2,3,4,5)
    val firstElement = aList.head
    val rest = aList.tail
    val aPrepentdList = 0 :: aList // List(0,1,2,3,4,5)
    val anExntendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

    //sequences
    val aSequence: Seq[Int] = Seq(1,2,3)  // Seq.apply(1,2,3)
    val accessedElement = aSequence(1) // return element of index 1: 2
    
    // vectors fast seq implementation
    val aVector = Vect(1,2,3,4,5,6)

    //sets = no duplicates
    val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
    val setHas5 = aSet.contains(5)
    val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
    val aRemovedSet = aSet - 3 // Set(1,2,4)

    // ranges
    val aRange = 1 to 1000
    val towByTwo = aRange.map(x => 2* x).toList // List(2,4,6,8. 2000)

    //tuples 
    val aTuple = ("Bon Jovi", "Rock", 1982)

    //maps
    val aPhoneBook : Map[String, Int] = Map(
        ("Daniel", 2232163),
        "Jane" -> 217281
    )
}