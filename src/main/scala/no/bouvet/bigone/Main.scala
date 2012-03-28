package no.bouvet.bigone

import io.Source

object Main extends App {
  val words = Source.fromFile("/Users/thomas/Dropbox/Private/Code/wordlist.txt").getLines.toList
  val start = System.currentTimeMillis();
  val anagrams = AnagramFinder.findAnagrams(words)
  val longest = AnagramFinder.findLongest(anagrams)
  val largestGroup = AnagramFinder.findLargestGroup(anagrams)
  val stop = System.currentTimeMillis();

  println("Done in " + (stop - start) + " ms")
  println("Total words: " + words.size)
  println("Number of anagrams: " + anagrams.values.size)
  println("Longest anagrams: " + longest)
  println("Largest group of anagrams: " + largestGroup)
}