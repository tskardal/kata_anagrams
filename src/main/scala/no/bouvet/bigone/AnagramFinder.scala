package no.bouvet.bigone

import collection.immutable.{Set, Map, List}


object AnagramFinder {
  def findAnagrams(words: List[String]) = {
    val emptyMap = Map[String, Set[String]]() withDefaultValue Set[String]()

    val anagrams = words.foldLeft(emptyMap) {
      (currentAnagrams, word) => addWord(currentAnagrams, word.trim.toLowerCase)
    }

    anagrams.filter(tuple => tuple._2.size > 1)
  }

  def addWord(currentAnagrams: Map[String, Set[String]], word: String) = {
    val matches = currentAnagrams(word.sorted)
    currentAnagrams + (word.sorted -> (matches + word))
  }

  def findLargestGroup(anagrams: Map[String, Set[String]]) = anagrams.maxBy(_._2.size)._2

  def findLongest(anagrams: Map[String, Set[String]]) = anagrams.maxBy(_._1.length)._2
}