(ns re-frame-a-to-z.events
    (:require [re-frame.core :as re-frame]
              [re-frame-a-to-z.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
