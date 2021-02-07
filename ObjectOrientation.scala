package com.rockthejvm

object ObjectOrientation extends App {
    //class and instance
    class Animal {
        val age: Int = 0

        def eat() = println("I'm eating")
    }
    val anAnimal = new Animal


    //inheritance
    class Dog (val name: String) extends Animal // constructor definition

    val aDog = new Dog("Lassie")

    //constructor arguments are NOT fields: need to put a val before the constructor argument

    // subtype polymorphism

    val aDeclaredAnimal: Animal = new Dog("Hachi")
    aDeclaredAnimal.eat()   // the most derived method will be called at runtime

    //abstract class
    abstract class WalkingAnimal {
        val hasLegs = true  // by default public, can be restrict by protected and private
        def walk(): Unit
    }

    // "interface" = ultimate abstract type
    trait Carnivore {
        def eat(animal: Animal): Unit
    }

    trait Philosopher {
        def ?!(thought: String): Uint  // ?! valid method name
    }

    // single-class inheritancem multi-trait mixing
    class Crocodile extends Animal with Carnivore with Philosopher {
        override def eat(animal: Animal) Uint = println("Wooo")

        override def ?!(thought: string) Uint = println(s"I was thinking: $thought")
    }

    val aCroc = new Crocodile
    aCroc.eat(aDog)

    aCroc eat aDog // infix notation = object argument, only available for methods with One argument
    aCroc ?! "What if I can fly?"

    //operators in Scala are actually methods
    val basicMath = 1 + 2
    val anotherBasicMethod = 1.+(2)  // equivalent

    //anonymous classes
    val dinosaur = new Carnivore {
        override def eat(animal: Animal): Uint = println("I am a dinosaur and eat")
    }

    /*
    what you tell the compilor
    class Carnivore_Anonymous_35728 extends Carnivore {
        override def eat(animal: Animal): Uint = println("I am a dinosaur and eat")
    }

    val dinosaur = new Canivore_Anonymous_35722222228
    */

    //singleton object
    object MySingleton {
        val mySpecialValue = 5231
        def mySpecialMethod(): Int = 3121

        //apply method is special
        def apply(x: Int): Int = x + 1
    } // the only instance of the MySinglton type

    MySingleton.mySpecialMethod()
    
    MySingleton.apply(65) // is equivalent to MySingleton(65)
    MySingleton(65)

    obejct Animal { // companions - companion object because we have the same name class
    //companions can access each other's private fields / methods
    //singleton Animal and instances of Animal are different things
        val canLiveIndefinitively = false
    }

    val animalsCanLiveForever = Animal.canLiveIndefinitively // "static" fields/methods

    /*
    case classes = lightweight data structure with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
    */
    case class Person(name: String, age: Int)
    
    //may be constructed without new
    val bob = Person ("Bob", 54) //Person.apply("Bob", 54)

    //exceptions
    try {
        // code that can throw
        val x: String = null
        x.length
    } catch {
        case e: Exception => "some faulty error message"
    } finally {
        //execute some code no matter what
    }

    // generics
    abstract class MyList[T] {
        def head: T
        def tail: myList[T]
    }

    val aList: List[Int] = List(1,2,3)
 // List.apply(1,2,3)
    val first = aList.head
    val rest = aList.tail

    val aStringList = List("Hello", "Scala")
    val firstString = aStringList.head

    //Point #1: in scala we usually operate with IMMUTABLE values/objects
    //Any modification to an object must return Another object
    /*
    benefits:
    1) works miracle in multithread/distributed env
    2) helps making sense of the code ("reasoning about")
    */
    val reversedList = aList.reverse


    //Point #2: scala is closest to the Object Orientated ideal
    //Every code is a class or object

    //java equivalent public static void main(String[] args)
}