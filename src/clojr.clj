(ns clojr
  (:require [cemerick.pomegranate :as pomegranate]))

(def clojars {"clojars" "http://clojars.org/repo"})

(def repositories
  (atom (merge cemerick.pomegranate.aether/maven-central clojars)))

(defn add-repository
  "Add a maven repository before loading dependencies from it

  Example:

      (use 'clojr)
      (add-repository \"clojars\" \"http://clojars.org/repo\")

  "
  [name uri]
	(swap! repositories #(assoc %1 name uri)))


(defn- force-clojure "Force our version of Clojure"
  [ql] (conj ql '[org.clojure/clojure "1.6.0"]))


(defn dependencies
  "
  Load Maven / clojars dependencies into the Java classpath.

  Example:

      (dependencies '[[cheshire \"5.3.1\"]
                      [data-validation \"1.0.1\"]])
  "
  [coordinates]
	(pomegranate/add-dependencies
     :coordinates (force-clojure coordinates)
     :repositories @repositories))



(defmacro dep
  ([name]
   (list 'clojr/dependencies (list 'quote [[(symbol name) "LATEST"]])))

  ([name version]
   (list 'clojr/dependencies (list 'quote [[(symbol name) version]])))

  ([name version use-ns]
   (list 'do (list (list 'clojr/dependencies (list 'quote [[(symbol name) version]]))
                   (list 'use (list 'quote (symbol use-ns)))
                   ))
   )

  )
