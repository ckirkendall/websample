(ns integrator.views.main
  (:use compojure.core)
  (:require [compojure.route :as route]
            [noir.session :as session]))

(defn my-func []
  (session/put! :num (inc (or (session/get :num) 0)))
  (str "The message is shown " (session/get :num) " times."))

(defroutes app-routes
  (GET "/" [] (my-func))
  (route/not-found "Not Found"))

