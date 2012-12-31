(ns main
  (:require [enfocus.core :as ef])
  (:require-macros [enfocus.macros :as em]))

(em/defsnippet my-snippet "/html/snippets.html" [:#mytest] []
  [:#this] (em/content "123"))

(defn ^:export mystart []
  (em/at js/document
         [:#here] (em/content (my-snippet))))

(set! (.-onload js/window) #(em/wait-for-load (mystart))) 
