(defproject integrator "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.0-RC1"]
                 [compojure "1.1.3"]
                 [lib-noir "0.3.0"]
                 [enfocus "1.0.0-beta2"]
                 [enlive "1.0.1"]
                 [com.mysql/connectorj "5.1.12"]
                 [korma "0.3.0-beta11"]
                 [org.clojure/clojurescript "0.0-1450"]]
  :plugins [[lein-ring "0.7.5"]
            [lein-cljsbuild "0.2.10"]]
  :ring {:handler integrator.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}}

  :aot []
  :source-paths ["src/clj"]
  :cljsbuild {
              :builds {
                       :main {
                              :source-path "src/cljs"
                              :compiler {
                                         :output-to "resources/public/js/main.js"
                                         :warnings true
                                         :optimizations :advanced
                                         :pretty-print true
                                         :print-input-delimiter false
                                         :output-dir ".clojurescript-output"
                                         :libs ["closure/library/third_party/closure"]
                                         }}}}
  :war {:name "integrator.war"})
