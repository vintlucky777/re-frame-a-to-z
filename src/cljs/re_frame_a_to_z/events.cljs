(ns re-frame-a-to-z.events
    (:require [re-frame.core :as rf]
              [re-frame-a-to-z.db :as db]))

(rf/reg-event-db
  :init-db
  (fn  [_ _]
    db/default-db))

(rf/reg-event-db
  :set-name
  (fn [db [_ name]]
    (assoc db :name name)))

(rf/reg-event-db
  :set-code
  (fn [db [_ code]]
    (assoc db :code code)))

(rf/reg-event-db
  :next-slide
  (fn [db]
    (let [slide (:slide db)
          next-slide (+ slide 1)]
      (assoc db :slide next-slide))))

(rf/reg-event-db
  :prev-slide
  (fn [db]
    (let [slide (:slide db)
          prev-slide (max 0 (- slide 1))]
      (assoc db :slide prev-slide))))

(rf/reg-event-db
  :new-emoji
  (fn [db [_ emoji]]
    (let [emojis (:emojis db)
          new-emojis (->> (concat emojis emoji) distinct (into []))]
      (assoc db :emojis new-emojis))))
