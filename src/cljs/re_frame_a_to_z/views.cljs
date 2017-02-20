(ns re-frame-a-to-z.views
    (:require [re-frame.core :as rf]
              [re-frame-a-to-z.slides :refer [slides]]))

(defn main-panel []
  (let [code (rf/subscribe [:code])
        active-slide (rf/subscribe [:slide])]
    (fn []
      [:div
        [:div.bg [:pre.code @code]]
        [:div.wrapper
          [(get slides @active-slide 0)]]])))
