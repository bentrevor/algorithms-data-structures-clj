(ns week-2.merge-sort)

(defn- tail [list]
  (vec (drop 1 list)))

(defn- merge-lists-iter [left right acc]
  (let [left-val (first left)
        right-val (first right)]
    (cond
     (and (empty? left) (empty? right))                 acc
     (empty? left)                                      (recur left        (tail right) (conj acc right-val))
     (or (empty? right) (< (first left) (first right))) (recur (tail left) right        (conj acc left-val))
     :else                                              (recur left        (tail right) (conj acc right-val)))))

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
