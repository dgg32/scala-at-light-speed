package com.rockthejvm

object Basics extends App {
    val meaningOfLife: Int = 42 // const int meaningofLife = 42

    //Int, Boolean, Char, Double, Float, String
    val aBoolean = false // type is optional

    val aString = "I love Scala"

    val aComposedString = "I" + " " + "love" + " " + "Scala"

    val anInterpolatedString = s"the meaing of life is $meaningOfLife"

    //expression = structures that can be reduced to a value
    val anExpression = 2 + 3

    // if expression
    val ifExpression = if (meaningOfLife > 43) 56 else 999           // in other language: meaningOfLife > 43 ? 56: 999
    val chainedIfExpression = 
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else 0

    //code blocks
    val aCodeBlock = {
        //definitions
        val aLocalValue = 67

        //value of block is the value of the last expression
        aLocalValue + 3
    }

    // define a function

    def myFunction (x: Int, y: String): String = {
        y + " " + x
    }

    //recursive functions
    def factorial(n: Int): Int = 
    if (n <= 1) 1
    else n * factorial(n-1)

    /*
    factorial(5) = 5 * factorial(4)
    factorial(4) = 4 * factorial(3)
    ...
    */

    println(factorial(5))

    // In Scala we don't use loops or iteration, we use recursions

    // the Unit type = no meaningful type === "void" in other language
    //type of SIDE EFFECTS
    println("I love Scala")  //System.out.println, console.log, print

    def myUnitReturningFunction(): Unit = {
        println ("I don't love return Unit")
    }


}

