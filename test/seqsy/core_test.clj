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

(facts "about printing tables"

       (fact "subsets of of keys in specified headings are honoured."
             (seqsy-table [{:a 1 :b 2} {:a 2 :c 3}] [:a]) => :fake
             (provided
              (seqsy-print [[:a] [1] [2]]) => :fake))


       (fact "missing keys are printed as nil."
             (seqsy-table [{:a 1 :b 2} {:a 1 :c 3}] [:a :b :c]) => :fake
             (provided
              (seqsy-print [[:a :b :c] [1 2 "nil"] [1 "nil" 3]]) => :fake))

       (fact "mixed key types don't break printing"
             (seqsy-table [{:a 1 10 2 "c" 3} {:a 4 10 5 "c" 6}] [:a 10 "c"]) => :fake
             (provided
              (seqsy-print [[:a 10 "c"] [1 2 3] [4 5 6]]) => :fake)))
