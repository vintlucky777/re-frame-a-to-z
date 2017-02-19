(ns re-frame-a-to-z.views
    (:require [re-frame.core :as rf]))

(defn main-panel []
  (let [name (rf/subscribe [:name])]
    (fn []
      [:div
        [:div "Hello from " @name]
        [:button.c1 "Click me!"]])))
