(ns clojr
  (:require [cemerick.pomegranate :as pomegranate]
            [cemerick.pomegranate.aether :as aether]))

(def clojars {"clojars" "https://repo.clojars.org"})

(def repositories
  "All our golden repos"
  (atom (merge aether/maven-central clojars)))

(defn add-repository
  "Add a maven repository before loading dependencies from it

  Example:

      (use 'clojr)
      (add-repository \"clojars\" \"https://repo.clojars.org\")

  "
  [name uri]
  (swap! repositories assoc name uri))


(defn- force-clojure
  "Pin the running Clojure version so dependency resolution doesn't try to upgrade it"
  [ql]
  (conj ql ['org.clojure/clojure (clojure-version)]))


(defn- ensure-dynamic-classloader!
  "JDK 9+ AppClassLoader isn't modifiable; make sure pomegranate has a DynamicClassLoader to add to."
  []
  (let [t (Thread/currentThread)
        cl (.getContextClassLoader t)]
    (when-not (instance? clojure.lang.DynamicClassLoader cl)
      (.setContextClassLoader t (clojure.lang.DynamicClassLoader. cl)))))

(defn dependencies
  "
  Load Maven / Clojars dependencies into the Java classpath.

  Example:

      (dependencies '[[cheshire \"5.13.0\"]
                      [data-validation \"1.0.1\"]])
  "
  [coordinates]
  (ensure-dynamic-classloader!)
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


(defn dirname [path]
  (.getParent (java.io.File. path)))

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
