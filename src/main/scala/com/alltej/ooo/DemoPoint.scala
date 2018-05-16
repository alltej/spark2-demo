package com.alltej.ooo

/**
  * @author Allan Tejano
  *         5/15/2018
  */
object DemoPoint {
  def main(args: Array[String]): Unit = {
    val pt = new Point(3, 5)

    pt.move(2, 2)

    println(pt.toString)
  }

}
