(ns clojr
  (:require [cemerick.pomegranate :as pomegranate]))

(def clojars {"clojars" "http://clojars.org/repo"})

(def repositories
  (atom (merge cemerick.pomegranate.aether/maven-central clojars)))

(defn add-repository [name uri]
	(swap! repositories #(assoc %1 name uri)))

(defn dependencies [coordinates]
	(pomegranate/add-dependencies
     :coordinates coordinates
     :repositories @repositories))
