(ns week-3.tree-traversal)

(defn tree-node [value children]
  {:value value
   :children children})

(declare breadth-first-flat-list-iter)
(declare depth-first-flat-list-iter)

(defn depth-first-flat-list [tree]
  (depth-first-flat-list-iter tree [(:value tree)]))

(defn depth-first-flat-list-iter [tree list-so-far]
  (if (= [] (:children tree)) list-so-far
      (let [list-of-children (map depth-first-flat-list (:children tree))]
        (flatten (vector list-so-far list-of-children)))))

(defn breadth-first-flat-list-iter [list-so-far current-roots]
  (let [current-gen-values (map :value current-roots)
        next-gen-roots (flatten (vector (map :children current-roots)))
        next-gen-list (flatten (vector list-so-far current-gen-values))]
    (if (= [] next-gen-roots) next-gen-list
        (breadth-first-flat-list-iter next-gen-list next-gen-roots))))

(defn breadth-first-flat-list [tree]
  (breadth-first-flat-list-iter [(:value tree)] (:children tree)))
