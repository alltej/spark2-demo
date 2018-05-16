package com.alltej.functionalprogramming

/**
  * @author Allan Tejano
  *         5/15/2018
  */
object FunctionalProgramming {
  def main(args: Array[String]): Unit = {

    //1. create a squareIt function that returns square of input x
    def squareIt(x:Int):Int = x*x

    //2. create a cubeIt function that returns cube of input x
    def cubeIt(x:Int):Int = x*x*x

    //3. create a calcIt function that that takes input x and a function of type squareIt/cubeIt
    def calcIt(x:Int, f:Int => Int) = f(x)

    val input = 3
    val y = calcIt(input, squareIt)
    println(s"Square of ${input} = ${y}")


    var z = calcIt(input, cubeIt)
    println(s"Cube of ${input} = ${z}")
  }
}
