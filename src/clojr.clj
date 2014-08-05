(ns clojr
  (:require [cemerick.pomegranate :as pomegranate]))

(def clojars {"clojars" "http://clojars.org/repo"})

(def repositories
  (atom (merge cemerick.pomegranate.aether/maven-central clojars)))

(defn add-repository [name uri]
  "Add a maven repository before loading dependencies from it

  Example:

      (use 'clojr)
      (add-repository \"clojars\" \"http://clojars.org/repo\")

  "
	(swap! repositories #(assoc %1 name uri)))

(defn dependencies [coordinates]
  "
  Load Maven / clojars dependencies into the Java classpath.

  Example:

      (dependencies '[[cheshire \"5.3.1\"]
                      [data-validation \"1.0.1\"]])
  "
	(pomegranate/add-dependencies
     :coordinates coordinates
     :repositories @repositories))
