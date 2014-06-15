(ns week-3.tree-traversal-spec
  (:require [speclj.core           :refer :all]
            [week-3.tree-traversal :refer :all]))

(describe "tree traversal"
  (let [tree (tree-node 1
                        [(tree-node 2
                                    [(tree-node 3 [])
                                     (tree-node 4 [])])
                         (tree-node 5 [])])]
    (it "traverses depth-first"
      (should= [1]
               (depth-first-flat-list (tree-node 1 [])))
      (should= [1 2 3 4 5]
               (depth-first-flat-list tree)))

    (it "traverses breadth-first"
      ;; (should= [1]
      ;;          (breadth-first-flat-list (tree-node 1 [])))
      (should= [1 2 5 3 4]
               (breadth-first-flat-list tree)))))
