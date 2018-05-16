package com.alltej.datasourcev2

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object DataSourceV2Demo {

  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sparkSession = SparkSession.builder.
      master("local[2]")
      .appName("example")
      .getOrCreate()

    val simpleDf = sparkSession.read.format("com.alltej.datasourcev2.simple")
      .load()

    simpleDf.show()
    println("number of partitions in simple source is "+simpleDf.rdd.getNumPartitions)

    val simpleMultiDf = sparkSession.read.format("com.alltej.datasourcev2.simplemulti")
      .load()

    simpleMultiDf.show()
    println("number of partitions in simple multi source is "+simpleMultiDf.rdd.getNumPartitions)

    val simpleCsvDf = sparkSession.read.format("com.alltej.datasourcev2.simplecsv")
      .load("src/main/resources/sales.csv")

    simpleCsvDf.printSchema()
    simpleCsvDf.show()
    println("number of partitions in simple csv source is "+simpleCsvDf.rdd.getNumPartitions)


    /**
      * using MySql
      */
//    val simpleMysqlDf = sparkSession.read.format("com.alltej.datasourcev2.simplemysql")
//      .load()
//
//    simpleMysqlDf.printSchema()
//    simpleMysqlDf.filter("user=\"root\"").show()
//    println("number of partitions in simple mysql source is "+simpleMysqlDf.rdd.getNumPartitions)
//
//
//
//    sparkSession.stop()

  }
}
