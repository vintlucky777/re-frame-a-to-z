(ns re-frame-a-to-z.views
    (:require [re-frame.core :as rf]
              [re-frame-a-to-z.slides :refer [slides]]
              [clojure.string :as str]))

(defn get-slide [slide-num]
  (let [slide (get slides slide-num)]
    (if slide
      [slide]
      [:div.slide
        [:h1 (str "no-slide! :num " slide-num)]])))

(defn emojis-block [emojis]
  (fn [emojis]
    (.log js/console emojis)
    [:div.emojis-block
      (into [:div.emojis]
        (map #(do (js/console.log %)
                  [:div.emoji-cnt
                   [(keyword (str "div.emoji" ".emoji-" (str/replace (:emoji %) ":" "")))]
                   [:div.author (:user_name %)]])
          emojis))]))

(defn main-panel []
  (let [code (rf/subscribe [:code])
        active-slide (rf/subscribe [:slide])
        emojis (rf/subscribe [:emojis])]
    (fn []
      (let [slide (get-slide @active-slide)]
        [:div
          [:div.bg [:pre.code @code]]
          [:div.wrapper slide]
          [:button.prev-slide {:onClick #(rf/dispatch [:prev-slide])} "⟵"]
          [:button.next-slide {:onClick #(rf/dispatch [:next-slide])} "⟶"]
          [emojis-block @emojis]]))))
