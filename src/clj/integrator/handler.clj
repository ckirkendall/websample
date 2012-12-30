(ns integrator.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [noir.util.middleware :as noir]
            [integrator.views.main :as view-main]))

(def app
  (-> [view-main/app-routes
       (route/resources "/")]
      noir/app-handler
      noir/war-handler))
