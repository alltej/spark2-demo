package com.alltej.wordcount

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

/**
  * @author Allan Tejano
  *         5/16/2018
  */
object WordCountBetterSorted_180516 {
  def main(args: Array[String]): Unit = {
    //1. Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    //2. Create a SparkContext using the local machine
    val sc = new SparkContext("local[*]", "wordcount")

    //3. Load each line of my book(/resources/book.txt) into an RDD
    val lines = sc.textFile(getClass.getResource("/book.txt").toString)

    //4. Split using a regular expression that extracts words
    val words = lines.flatMap(x => x.split("\\W+"))

    //5. Normalize everything to lowercase
    val lowerCaseWords = words.map(x => x.toLowerCase())

    //6. Count of the occurrences of each word
    val wordsCount = lowerCaseWords.map(x => (x,1)).reduceByKey((x, y) => x+y)

    //7. Flip (word, count) tuples to (count, word) and then sort by key (the counts)
    val wordCountSorted = wordsCount.map(x => (x._2, x._1)).sortByKey()

    //8. Print the results, flipping the (count, word) results to word: count as we go.
    for(result <- wordCountSorted) {
      val word = result._2
      val count = result._1
      println(s"$word : $count")
    }
  }
}
