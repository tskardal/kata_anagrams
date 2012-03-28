package no.bouvet.bigone

import org.specs2.mutable._


class AnagramKataSpec extends Specification {
  "An anagram finder" should {
    "find zero anagrams in an empty list of words" in {
      val anagrams = AnagramFinder.findAnagrams(List[String]())
      anagrams must have size (0)
    }
  }
}