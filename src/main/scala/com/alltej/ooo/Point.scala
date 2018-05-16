package com.alltej.ooo

/**
  * @author Allan Tejano
  *         5/15/2018
  */
class Point(val x: Int, val y: Int) {

  var x1 = x
  var y1 = y
  def move(dx: Int, dy: Int) = {
    x1 = x + dx
    y1 = y + dy
  }


  override def toString = s"Point($x1, $y1)"
}
