(ns re-frame-a-to-z.events
    (:require [re-frame.core :as rf]
              [re-frame-a-to-z.db :as db]
              [chord.client :refer [ws-ch]]
              [cljs.core.async :refer [<! >! put! close!]])
    (:require-macros [cljs.core.async.macros :refer [go]]))

(defn get-server-message []
  (go
    (let [{:keys [ws-channel]} (<! (ws-ch "ws://www.clojure.tv/" {:format :json-kw}))
          evt (<! ws-channel)
          evt-map (into {} (:message evt))]
      (js/console.log "Got message from server:" evt evt-map)
      (rf/dispatch [:new-emoji evt-map])
      (get-server-message))))

(get-server-message)

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
  (fn [db [_ evt]]
    (let [prev-emojis (:emojis db)
          emoji (into {} evt)
          new-emojis (->> (concat prev-emojis [emoji]) (take-last 10) (into []))]
      (js/console.log emoji new-emojis)
      (assoc db :emojis new-emojis))))
