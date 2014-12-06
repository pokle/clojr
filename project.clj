(defproject clojr "0.4.0"
  :description "Run single file clojure apps"
  :url "https://github.com/pokle/clojr"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.cemerick/pomegranate "0.3.0"]
                 [reply "0.3.4"]]
  :profiles {:uberjar {:aot :all}}

  :plugins [[lein-pprint "1.1.1"]]

  :main reply.ReplyMain
)
