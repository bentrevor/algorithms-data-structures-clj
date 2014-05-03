(ns week-1.linked-list-spec
  (:require [speclj.core        :refer :all]
            [week-1.linked-list :refer :all]))

(describe "prepend"
  (it "prepends nodes to an empty list"
    (should= 0
             (:value (prepend 0 {}))))

  (it "prepends multiple nodes"
    (let [list (prepend 0 (prepend 1 {}))]
      (should= 0
               (:value list))
      (should= 1
               (:value (:next-node list))))))

(describe "length"
  (it "gets the length of an empty list"
    (should= 0
             (length {})))

  (it "gets the length of a non-empty list"
    (should= 3
             (length (prepend 0 (prepend 1 (prepend 2 {})))))))

(describe "get"
  (it "gets the value at index n"
    (let [list (prepend 0 (prepend 1 (prepend 2 {})))]
      (should= 0
               (get-value 0 list))
      (should= 1
               (get-value 1 list))
      (should= 2
               (get-value 2 list)))))

(describe "append"
  (it "appends a node to empty list"
    (should= 0
             (:value (append 0 {}))))

  (it "appends multiple nodes"
    (let [list (append 1 (append 0 {}))]
      (should= 0
               (:value list))
      (should= 1
               (:value (:next-node list))))))

(describe "insert-before"
  (it "inserts into the middle of a list"
    (let [original-list (prepend :start (prepend :end {}))
          list          (insert-before 1 :value original-list)]
      (should= :start
               (get-value 0 list))
      (should= :value
               (get-value 1 list))
      (should= :end
               (get-value 2 list))))

  (it "inserts into the beginning of a list"
    (let [original-list (prepend :initial-start {})
          list          (insert-before 0 :new-start original-list)]
      (should= :new-start
               (get-value 0 list))
      (should= :initial-start
               (get-value 1 list))))

  (it "fails to insert when out of bounds"
    (should-throw (insert-before 100 :value {}))))

(describe "sorted-insert"
  (it "can insert into an empty list"
    (let [list (sorted-insert 10 {})]
      (should= 10
               (get-value 0 list))))

  (it "inserts elements in order from least to greatest"
    (let [list (sorted-insert 4 (sorted-insert 0 (sorted-insert 5 (sorted-insert 10 {}))))]
      (should= 0
               (get-value 0 list))
      (should= 4
               (get-value 1 list))
      (should= 5
               (get-value 2 list))
      (should= 10
               (get-value 3 list)))))

(describe "my-reverse"
  (it "reverses an empty list"
    (should= {}
             (my-reverse {})))

  (it "reverses a list with one element"
    (let [list {:value :yolo
                :next-node {}}]
      (should= list
               (my-reverse list))))

  (it "reverses a list"
    (let [list (prepend :a (prepend :b (prepend :c {})))
          reversed-list (my-reverse list)]
      (should= :c
               (get-value 0 reversed-list))
      (should= :b
               (get-value 1 reversed-list))
      (should= :a
               (get-value 2 reversed-list)))))
