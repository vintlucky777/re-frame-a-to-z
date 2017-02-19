(ns re-frame-a-to-z.events
    (:require [re-frame.core :as rf]
              [re-frame-a-to-z.db :as db]))

(rf/reg-event-db
  :init-db
  (fn  [_ _]
    db/default-db))

(rf/reg-event-db
  :name
  (fn [db [_ name]]
    (assoc db :name name)))

(rf/reg-event-db
  :code
  (fn [db [_ code]]
    (assoc db :code code)))
