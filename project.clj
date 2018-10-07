                        (defproject chatter "0.1.0-SNAPSHOT"
                          :description "clojure web app for displaying messages"
                          :url "http://example.com/FIXME"
                          :min-lein-version "2.0.0"
                          :dependencies [[org.clojure/clojure "1.9.0"]
                                         [compojure "1.6.1"]
                                         [ring/ring-defaults "0.3.2"]
                                         [ring/ring-jetty-adapter "1.7.0"]
                                         [hiccup "1.0.5"]
                                         [hickory "0.7.1"]
                                         [environ "1.0.2"]]
                          :plugins [[lein-ring "0.9.7"]
                                    [lein-environ "1.0.0"]]
                          :ring {:handler chatter.handler/app
                                 :init chatter.handler/init
                                 :destroy chatter.handler/destroy}
                          :aot :all
                          :main chatter.handler
                          :profiles
                          {:dev
                           {:dependencies [[javax.servlet/servlet-api "2.5"]
                                           [ring/ring-mock "0.3.2"]]}
                           :production
                           {:ring
                            {:open-browser? false, :stacktraces? false, :auto-reload? false}
                            :env {production true}}}
                          :uberjar-name "chatter-standalone.jar")
