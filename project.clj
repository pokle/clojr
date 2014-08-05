(defproject clojr "0.1.1"
  :description "Run single file clojure apps"
  :url "https://github.com/pokle/clojr"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.cemerick/pomegranate "0.3.0"]]
  :profiles {:uberjar {:aot :all}}
)
