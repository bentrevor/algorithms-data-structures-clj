(ns week-1.linked-list)

(defn prepend [value list]
  {:value value
   :next-node list})

(defn get-value [index list]
  (if (= 0 index)
    (:value list)
    (get-value (- index 1) (:next-node list))))

(defn append [value list]
  (if (= {} list)
    {:value value
     :next-node {}}
    {:value (:value list)
     :next-node (append value (:next-node list))}))

(defn length [list]
  (if (= list {})
    0
    (+ 1 (length (:next-node list)))))

(defn insert-before [index value list]
  (cond
   (or (< index 0) (> index (length list))) (throw "Swag")
   (= 0 index)                         (prepend value list)
   :else {:value (:value list)
          :next-node (insert-before (- index 1) value (:next-node list))}))
