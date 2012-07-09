(ns seqsy.core-test
  (:use seqsy.core
        midje.sweet))

(facts "about columns"
       (columns [[1 2 3] [4 5 6] [7 8 9]]) => [[1 4 7] [2 5 8] [3 6 9]]
       (columns [[1]])                     => [[1]]
       (columns [[]])                      => [])

(facts "about column sizing"
       (column-widths [["a" "ab" "abc"]])  => [3]
       (column-widths [["abcde"] ["a"]])   => [5 1]
       (column-widths [["" ""] [""]])      => [0 0])

(facts "about row spacing"
       (pad-row ["hello" "world"] [5 5])   => "hello  world"
       (pad-row ["a" "bc" "d"] [5 4 3])    => "a      bc    d  ")
