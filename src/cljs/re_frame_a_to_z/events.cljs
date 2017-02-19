(ns re-frame-a-to-z.events
    (:require [re-frame.core :as rf]
              [re-frame-a-to-z.db :as db]))

(rf/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
