(ns re-frame-a-to-z.helpers)

(defn tag-range
  ([tag rng]
   (tag-range tag rng nil))
  ([tag rng rng-end]
   (some->> [rng rng-end]
      (filter identity)
      not-empty
      (apply range)
      (into [])
      (map #(do ^{:key %} [tag %])))))


(defn ->val
  [event]
  (-> event .-target .-value))
