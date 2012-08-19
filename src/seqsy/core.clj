(ns seqsy.core
  "Function(s) for printing seqs readably at the REPL."
  (:require [clojure.string :as str]
            [clojure.set    :as set]))

(defn columns
  "If seqs is 2-dimensional, return a sequence of what should
   be the columns."
  [seqs]
  (let [column (map first seqs)]
    (if (every? nil? column)
      (empty seqs)
      (cons column (columns (map rest seqs))))))

(defn column-widths
  "Returns a list of integers representing the required
   width (in chars) for each column."
  [columns]
  (map (fn [col] (apply max (map (comp count str) col))) columns))

(defn pad-elem
  "Return a single element padded to its desired width."
  [elem width]
  (let [s-elem (str elem)]
   (str s-elem (apply str (repeat (- width (count s-elem)) " ")))))

(defn pad-row
  "Return a string representing the given row, spaces according
   to widths provided."
  [row widths]
  (str/join "  " (map pad-elem row widths)))

(defn seqsy-print
  "Print a 2D seq-of-seqs readably."
  [seq-o-seqs]
  (let [widths (column-widths (columns seq-o-seqs))]
    (doseq [row seq-o-seqs]
      (println (pad-row row widths)))))

(defn make-getter
  "Given a value, returns a function that gets it from a map."
  [val]
  (fn [m] (get m val "nil")))

(defn seqsy-table
  "Given a sequence of maps, convert to a seqsy-printed table."
  ([seq-o-maps]
     (seqsy-table seq-o-maps (apply set/union (map (comp set keys) seq-o-maps))))
  ([seq-o-maps headings]
     (seqsy-print (concat [headings]
                          (map (apply juxt (map make-getter headings)) seq-o-maps)))))
