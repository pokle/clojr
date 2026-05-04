(defproject clojr "0.6.3"
  :description "Run single file clojure apps"
  :url "https://github.com/pokle/clojr"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.12.4"]
                 [clj-commons/pomegranate "1.3.26"]
                 [org.slf4j/slf4j-nop "2.0.17"]
                 [reply "0.5.1"]]

  :plugins [[lein-pprint "1.3.2"]
            [lein-ancient "1.0.0-RC3"]]

  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :sign-releases false
                                    :username :env/clojars_username
                                    :password :env/clojars_password}]])
