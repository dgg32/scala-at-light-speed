package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

    //lazy evaluation
    //useful in infinite collections
    lazy val aLazyValue = 2
    lazy val lazyValueWithSideEffect = {
        println("I am lazy")
        43
    }

    val eagerValue = lazyValueWithSideEffect + 1

    //pseudo-collections: Option, Try
    def methodWhichCanReturnNull(): String = "Hello, scala"

    val anOption = Option(methodWhichCanReturnNull())

    //option = "collection" which contains at most one element: Some(value) or None

    val stringProcessing = anOption match {
        case Some(string) => s"I have obtained a valid $string"
        case None => "I obtained nothing"
    }

    //map, flatMap, filter

    def methodWhichCanThrowException(): String = throw new RuntimeException
    val aTry = Try(methodWhichCanThrowException())

    // a try = "collection" with either a value if the code went well, or an exception if the code threw one

    val anotherStringProcession = aTry match {
        case Success(validValue) => s"I have obtained a valid string $validValue"
        case Failure(ex) => "I obtained exception"
    }

    /*
    Evaluate something on another thread
    * asynchronous programming
    */
    val aFuture = Future({
        println ("loading")
        Thread.sleep(1000)
        println ("I have computed a value")
        67
    })

    //future is a "collection" which contains a value when it's evaluated
    //future is composable with map, flatMap and filter
    //monads
    Thread.sleep(2000)

    /**
    implictis basics
    */

    //#1 implicit arguments
    def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
    implicit val myImplicitInt = 46
    println (aMethodWithImplicitArgs)

    implicit class MyRichInteger(n: Int) {
        def isEven() = n % 2 == 0
    }

    println(23.isEven())  // new MyRichInteger(23).isEven
}