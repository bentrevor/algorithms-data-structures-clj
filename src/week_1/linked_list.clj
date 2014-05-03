(ns week-1.linked-list)

(defn build-list [head tail]
  {:value head
   :next-node tail })

(defn empty-list? [list]
  (= {} list))

(defn prepend [value list]
  (build-list value list))

(defn get-value [index list]
  (if (= 0 index)
    (:value list)
    (recur (dec index) (:next-node list))))

(defn append [value list]
  (if (empty-list? list)
    (build-list value
                {})
    (build-list (:value list)
                (append value (:next-node list)))))

(defn length [list]
  (if (empty-list? list)
    0
    (inc (length (:next-node list)))))

(defn insert-before [index value list]
  (cond
   (or (< index 0) (> index (length list))) (throw "Swag")
   (= 0 index)                              (prepend value list)
   :else (build-list (:value list)
                     (insert-before (dec index) value (:next-node list)))))

(defn sorted-insert [value list]
  (if (or (empty-list? list) (< value (:value list)))
    (prepend value list)
    (build-list (:value list)
                (sorted-insert value (:next-node list)))))

(defn- reverse-iter [list index list-so-far]
  (if
   (= (length list) index) list-so-far
   (recur list
          (inc index)
          (prepend (get-value index list) list-so-far))))

(defn my-reverse [list]
  (reverse-iter list 0 {}))
