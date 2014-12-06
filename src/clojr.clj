(ns clojr
  (:require [cemerick.pomegranate :as pomegranate]))

(def clojars {"clojars" "http://clojars.org/repo"})

(def repositories
     "All our golden repos"
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
  Load Maven / s dependencies into the Java classpath.

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
                   (list 'use (list 'quote (symbol use-ns)))))))


;
; from https://groups.google.com/forum/?fromgroups#!topic/clojure/cg7tFlgZYSw
(defmacro __FILE__ []
  `(if *file*
        (let [f# (ClassLoader/getSystemResource *file*)]
         (if f#
           (.getCanonicalPath (java.io.File. (.toURI f#)))
           (.getCanonicalPath (java.io.File. *file*))))))

(defmacro __DIR__ []
  `(dirname (__FILE__)))

(defn dirname [path]
  (.getParent (java.io.File. path)))


(defn foo
  "Does foo"
  [x] (* x x))


