(ns week-2.merge-sort-spec
  (:require [speclj.core       :refer :all]
            [week-2.merge-sort :refer :all]))

(describe "merge sort"
  (it "merges two lists"
    (let [left  [1 5]
          right [4 10]]
      (should= [1 4 5 10]
               (merge-lists left right))))

  (it "sorts a list"
    (should= [0, 1, 2, 4, 5, 6, 7, 9, 74]
             (merge-sort [7,2,5,4,9,1,6,74,0]))))
