(defproject clojr "0.5.0"
  :description "Run single file clojure apps"
  :url "https://github.com/pokle/clojr"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.cemerick/pomegranate "0.3.1"]
                 [reply "0.3.7"]]
  :profiles {:uberjar {:aot :all}}

  :plugins [[lein-pprint "1.1.1"]
            [lein-ancient "0.6.8"]]

  :main reply.ReplyMain
)
