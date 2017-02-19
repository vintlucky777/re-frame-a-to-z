(ns re-frame-a-to-z.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [re-frame-a-to-z.events]
              [re-frame-a-to-z.subs]
              [re-frame-a-to-z.views :as views]
              [re-frame-a-to-z.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
