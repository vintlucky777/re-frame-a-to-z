(ns re-frame-a-to-z.api
    (:require [re-frame.core :as rf]
              [chord.client :as chord]
              [cljs.core.async :as async])
    (:require-macros [cljs.core.async.macros :refer [go]]))

(defn init-server-listener []
  (go
    (let [{:keys [ws-channel]} (async/<! (chord/ws-ch "ws://www.clojure.tv/" {:format :json-kw}))]
      (loop []
        (let [evt (async/<! ws-channel)
              evt-map (into {} (:message evt))]
          (rf/dispatch [:new-emoji evt-map])
          (recur))))))
