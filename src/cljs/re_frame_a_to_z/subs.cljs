(ns re-frame-a-to-z.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as rf]))

(rf/reg-sub
 :name
 (fn [db]
   (:name db)))

(rf/reg-sub
 :code
 (fn [db]
   (:code db)))

(rf/reg-sub
 :slide
 (fn [db]
   (:slide db)))
