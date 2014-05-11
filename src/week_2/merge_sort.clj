(ns week-2.merge-sort)

(defn- merge-lists-iter [left right acc]
  (cond
   (and (empty? left) (empty? right)) acc
   (empty? left)                      (recur left (vec (drop 1 right)) (conj acc (first right)))
   (empty? right)                     (recur (vec (drop 1 left)) right (conj acc (first left)))
   (< (first left) (first right))     (recur (vec (drop 1 left)) right (conj acc (first left)))
   :else                              (recur left (vec (drop 1 right)) (conj acc (first right)))))

(defn merge-lists [left right]
  (merge-lists-iter left right []))

(defn merge-sort [list]
  (let [midpoint (/ (count list) 2)
        left (subvec list 0 midpoint)
        right (subvec list midpoint)]
    (if (= (count list) 1)
      list
      (merge-lists (merge-sort left)
                   (merge-sort right)))))
