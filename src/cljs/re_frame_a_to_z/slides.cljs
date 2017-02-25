(ns re-frame-a-to-z.slides
    (:require [re-frame.core :as rf]
              [re-frame-a-to-z.helpers :as h]
              [clojure.string :as str]))

(defn slide-0 []
  (fn []
    [:div.slide.slide-title
      [:h2 "re-frame"]
      [:h2 "A ⤏ Z"]
      [:h2 "по полочкам"]
      [:hr]
      [:hr]
      [:p "Виктор Клочихин"]
      [:hr]
      [:p "Moscow Clojure(Script) Meetup"]
      [:small "Feb 25, 2017"]]))


(defn slide-about-me []
  (let [text (->>
              ["(def speaker"
               "  {:name         \"Victor Klochikhin\""
               "   :github       \"vintlucky777\""
               "   :location     \"Moscow\""
               "   :company      \"Trucker Path\""
               "   :hobbies      [\"gamedev\" \"apps\""
               "                  \"travel\" \"surfing\"]"
               "   :achievements [\"однажды опечатался и с тех пор"
               "                   программирую на клоэи\"]})"]
              (str/join "\n"))]
    (fn []
      [:div.slide.sl-about-me
        [:div
          [:h2 "About me"]
          [:div.slide-row
            [:img {:src "/img/speaker.small.jpg"}]
            [:div.code
              [:pre text]]]]])))

(defn comics-slide [img]
  [:div.slide
    [:div
      [:img {:src img :width "600"}]]])
(defn comics-1 [] (comics-slide "img/alena_live.jpg"))
(defn comics-2 [] (comics-slide "img/but_no_no.jpg"))
(defn comics-3 [] (comics-slide "img/chotkiy_coder.jpg"))
(defn comics-4 [] (comics-slide "img/dzen_dog.jpg"))

(defn re-frame-title []
  [:div.slide
     [:a {:href "https://github.com/Day8/re-frame" :target "_blank"}
       [:img {:src "https://github.com/Day8/re-frame/blob/master/images/logo/re-frame_512w.png?raw=true" :height 100}]]
     [:hr]
     [:div
       [:iframe {:src "https://ghbtns.com/github-btn.html?user=day8&repo=re-frame&type=star&count=true&size=large"
                 :frameBorder "0"
                 :scrolling "0"
                 :width "160px"
                 :height "30px"}]
       [:iframe {:src "https://ghbtns.com/github-btn.html?user=day8&repo=re-frame&type=fork&count=true&size=large"
                 :frameBorder "0"
                 :scrolling "0"
                 :width "160px"
                 :height "30px"}]]])

(def re-frame-def-text
  ["(def re-frame"
   "  {:type        \"SPA-framework\""
   "   :render      \"reagent hiccup\""
   "   :approach    \"event-driven, singular state\""])

(defn slide-re-frame-def-1 []
  (let [text (->>
              (concat re-frame-def-text ["})"])
              (str/join "\n"))]
    (fn []
      [:div.slide
        [:div.code
          [:h2 "So what's that?"]
          [:pre text]]])))

(defn slide-re-frame-def-2 []
  (let [text (->>
              (concat re-frame-def-text
               ["   :pros        \"events! singular state!\""
                "})"])
              (str/join "\n"))]
    (fn []
      [:div.slide
        [:div.code
          [:h2 "So what's that?"]
          [:pre text]]])))

(defn slide-re-frame-def-3 []
  (let [text (->>
              (concat re-frame-def-text
               ["   :pros        \"events! singular state!\""
                "   :cons        \"😖events? singular state?!😱\""
                "})"])
              (str/join "\n"))]
    (fn []
      [:div.slide
        [:div.code
          [:h2 "So what's that?"]
          [:pre text]]])))

(defn slide-re-frame-concept []
  [:div.slide.sl-rf-concept
    [:h2 "Core concept"]
    [:img {:src "https://raw.githubusercontent.com/Day8/re-frame/master/images/the-water-cycle.png"}]
    [:p "looped event-data-view flow"]])

(defn slide-re-frame-diagram []
  [:div.slide.sl-rf-diagram
    [:div
      [:h2 "Event-data-flow"]
      [:img {:src "/img/6dominoes.png" :width 240}]
      [:p "looped event-data-view flow"]]])

(defn slide-re-frame-tools-0 []
  [:div.slide.sl-rf-tools
    [:div
      [:h2 "Daily tools"]
      [:hr]
      [:div.code
        [:pre (str/join "\n" ["(def default-db"
                              "  {:name \"re-frame A to Z\""
                              "   :slide 0"
                              "   :emojis []})"])]]]])

(defn slide-re-frame-tools-1 []
  [:div.slide.sl-rf-tools
    [:div
      [:h2 "Daily tools"]
      [:hr]
      [:code "(rf/rev-event-db [ev-name fn-new-db])"]
      [:div.code
        [:pre (str/join "\n" ["(rf/reg-event-db"
                              "  :set-name"
                              "  (fn [db [_ name]]"
                              "    (assoc db :name name)))]])"])]]]])

(defn slide-re-frame-tools-2 []
  [:div.slide.sl-rf-tools
    [:div
      [:h2 "Daily tools"]
      [:hr]
      [:code "(rf/dispatch [:some-event & args])"]]])

(defn slide-re-frame-tools-3 []
  [:div.slide.sl-rf-tools
    [:div
      [:h2 "Daily tools"]
      [:hr]
      [:div [:code "(rf/subscribe :some-event)"]]
      [:div.code
        [:pre (str/join "\n" ["(defn element []"
                               "  (let [store-val (rf/subscribe :some-event)]"
                               "    (fn []"
                               "      [:div (str \"value is \" @store-val)])))"])]]]])


(defn slide-re-frame-patterns []
  [:div.slide.sl-rf-tools
    [:div
      [:h2 "Patterns"]
      [:code "(defn [] azaza)"]]])



(defn slide-frontend-hell [hell-step]
  (let [name (rf/subscribe [:name])
        code (rf/subscribe [:code])
        code (rf/subscribe [:code])]
    (fn [hell-step]
      [:div.card.frontend-hell
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
          [:ol (h/tag-range :li 4 7)]]
        (when (> hell-step 0)
          [:div.decors
            [:div.decor-1]
            [:div.decor-2]
            [:div.decor-3]
            [:div.decor-4]
            [:div.decor-5]
            [:div.decor-wut]])])))

(defn demos-title []
  [:div.slide
    [:h1 "Demo time!"]])

(defn demos-app []
  [:div.slide
    [:h2 "Simple SPA"]
    [:hr]
    [:div.code {:style {:fontSize "200%"}} "RTFS!'"]
    [:hr]
    [:p [:small "' read the ******* sources"]]])

(defn demos-time-machine []
  [:div.slide
    [:h2 "Time machine"]
    [:hr]
    [:div.code
      [:pre
        (str/join "\n" ["(def db"
                        "  {..."
                        "    :log []"
                        "    :log-step nil})"
                        ""
                        ""
                        "(rf/reg-event-db"
                        "  :set-name"
                        "  (fn [db]"
                        "    (last (:log db))))"
                        ""
                        ""
                        "(rf/dispatch [:rollback])"])]]])

(defn demos-server-events []
  [:div.slide
    [:h2 "Server events"]
    [:hr]
    [:p [:a {:href "http://clojure.tv"} "clojure.tv"]]])

(defn end-slide []
  [:div.slide.end-slide
    [:img {:src "/img/end_poster.jpg"}]
    [:h1 "Thank you!"]])

(def slides
  [slide-0
   slide-about-me
   #(do [:div.slide [:h1 "Intro"]])
   slide-frontend-hell
   #(do [slide-frontend-hell 1])
  ;  #(do [slide-frontend-hell 2])
   comics-1
   comics-2
   comics-3
   comics-4
   re-frame-title
   slide-re-frame-def-1
   slide-re-frame-def-2
   slide-re-frame-def-3
   slide-re-frame-concept
   slide-re-frame-diagram
   slide-re-frame-tools-0
   slide-re-frame-tools-1
   slide-re-frame-tools-2
   slide-re-frame-tools-3
   slide-re-frame-patterns
   demos-title
   demos-app
   demos-time-machine
   demos-server-events
   end-slide])
