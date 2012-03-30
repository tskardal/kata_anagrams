package no.bouvet.bigone

import collection.immutable.List

object AnagramFinder {

  def findAnagrams(words: List[String]) : Map[String, Set[String]] = {
    val initialAnagrams = Map[String, Set[String]]() withDefaultValue Set[String]()

    val anagrams = words.foldLeft(initialAnagrams)(addWord)

    anagrams.filter(tuple => tuple._2.size > 1)
  }

  def addWord(currentAnagrams: Map[String, Set[String]], w: String) = {
    val newWord = w.trim.toLowerCase
    val matches = currentAnagrams(newWord.sorted)
    currentAnagrams + (newWord.sorted -> (matches + newWord))
  }

  def findLargestGroup(map: Map[String, Set[String]]) = map.maxBy(_._2.size)._2

  def findLongest(map: Map[String, Set[String]]) = map.maxBy(_._1.length)._2
}