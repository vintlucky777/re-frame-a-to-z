(ns re-frame-a-to-z.views
    (:require [re-frame.core :as rf]))

(defn tag-range
  ([tag rng]
   (tag-range tag rng nil))
  ([tag rng rng-end]
   (some->> [rng rng-end]
      (filter identity)
      not-empty
      (apply range)
      (into [])
      (map #(do ^{:key %} [tag %])))))

(defn ->val
  [event]
  (-> event .-target .-value))

(defn main-panel []
  (let [name (rf/subscribe [:name])
        code (rf/subscribe [:code])]
    (fn []
      [:div
        [:div.bg [:pre.code @code]]
        [:div.wrapper
          [:div.card
            [:h2 "Welcome: " @name]
            [:p "Here comes a little sniffy demo"]
            [:div
              [:h3 "The buttons"]
              [:button {:onClick #(rf/dispatch-sync [:init-db])} "Reset"]
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
              [:input {:value @name :onChange #(->> % ->val (conj [:name]) rf/dispatch-sync)}]
              [:input.success {:value @name :onChange #(->> % ->val (conj [:name]) rf/dispatch-sync)}]
              [:input.error {:value @name :onChange #(->> % ->val (conj [:name]) rf/dispatch-sync)}]
              [:input {:disabled true :value @name :onChange #(->> % ->val (conj [:name]) rf/dispatch-sync)}]
              [:textarea.code {:placeholder "Place your code here..." :value @code :onChange #(->> % ->val (conj [:code]) rf/dispatch-sync)}]]
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
              [:ul (tag-range :li 1 4)]
              [:p "Numbers"]
              [:ol (tag-range :li 4 7)]]]]])))
