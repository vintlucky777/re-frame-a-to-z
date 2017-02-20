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
  (fn [db [_ code]]
    (->> db :slide (+ 1) (assoc db :slide))))

(rf/reg-event-db
  :prev-slide
  (fn [db [_ code]]
    (->> db :slide (- 1) (max 0) (assoc db :slide))))
