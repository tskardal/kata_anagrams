package no.bouvet.bigone

import org.specs2.mutable._


class AnagramKataSpec extends Specification {
  "An anagram finder" should {

    "find zero anagrams in an empty list of words" in {
      val anagrams = AnagramFinder.findAnagrams(List[String]())
      anagrams must have size (0)
    }

    "find two anagrams in a list of three words where two consists of the same characters" in {
      val anagrams = AnagramFinder.findAnagrams(List[String]("abc","xyz","cab"))
      anagrams("abc") must contain("abc", "cab").only
    }

    "ignore words that have no anagrams" in {
      val anagrams = AnagramFinder.findAnagrams(List[String]("abc","xyz","cab"))
      anagrams("xyz") must have size(0)
    }

    "ignore case and leading/trailing whitespace" in {
      val anagrams = AnagramFinder.findAnagrams(List[String](" abc","cAb "))
      anagrams("abc") must contain ("abc", "cab")
    }

    "ignore duplicate words" in {
      val anagrams = AnagramFinder.findAnagrams(List[String]("abc","abc", "cab"))
        anagrams("abc") must contain ("abc", "cab").only
    }
  }
}