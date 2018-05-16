package com.alltej.datasourcev2

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object DataSourceV2MySqlDemo {

  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val sparkSession = SparkSession.builder.
      master("local[2]")
      .appName("example")
      .getOrCreate()
    /**
      * using MySql
      */
    val simpleMysqlDf = sparkSession.read.format("com.alltej.datasourcev2.simplemysql")
      .load()

    simpleMysqlDf.printSchema()
    simpleMysqlDf.filter("user=\"root\"").show()
    println("number of partitions in simple mysql source is "+simpleMysqlDf.rdd.getNumPartitions)



    sparkSession.stop()

  }
}
