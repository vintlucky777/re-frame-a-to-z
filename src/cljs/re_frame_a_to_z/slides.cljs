(ns re-frame-a-to-z.slides
    (:require [re-frame.core :as rf]
              [re-frame-a-to-z.helpers :as h]))

(defn slide-1 []
  (let [name (rf/subscribe [:name])
        code (rf/subscribe [:code])]
    (fn []
      [:div.card
        [:h2 "Welcome: " @name]
        [:p "Here comes a little sniffy demo"]
        [:div
          [:h3 "The buttons"]
          [:button {:onClick #(rf/dispatch [:init-db])} "Reset"]
          [:button.primary "Primary"]
          [:button.success "Success"]
          [:button.danger "Danger"]]
        [:div
          [:h3 "Button sizes"]
          [:button.xl "Super"]
          [:button.lg "Large"]
          [:button "Basic"]
          [:button.sm "Small"]
          [:button.xs "I'm tiny"]]
        [:div
          [:h3 "Inputs"]
          [:input {:value @name :onChange #(->> % h/->val (conj [:set-name]) rf/dispatch)}]
          [:input.success {:value @name :onChange #(->> % h/->val (conj [:set-name]) rf/dispatch)}]
          [:input.error {:value @name :onChange #(->> % h/->val (conj [:set-name]) rf/dispatch)}]
          [:input {:disabled true :value @name}]
          [:textarea.code {:placeholder "Place your code here..." :value @code :onChange #(->> % h/->val (conj [:set-code]) rf/dispatch)}]]
        [:div
          [:h3 "Typography"]
          [:h1 "Title h1"]
          [:h2 "Title h2"]
          [:h3 "Title h3"]
          [:h4 "Title h4"]
          [:h5 "Title h5"]
          [:p "Regular text with " [:a {:href "#"} "link"] "."]
          [:p [:i "Also in italics"] " and " [:b "bold statements!"]]]
        [:div
          [:h3 "Lists"]
          [:p "Bullets"]
          [:ul (h/tag-range :li 1 4)]
          [:p "Numbers"]
          [:ol (h/tag-range :li 4 7)]]])))


(def slides
  [slide-1])
