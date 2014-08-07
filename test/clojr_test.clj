(ns clojr-test
  (:require [clojure.test :refer :all]
            [clojr :refer :all]))

(deftest another
  (testing "parse json by dynamically loading cheshire"
    (dep cheshire "5.3.1" cheshire.core)
    (is (= {:a 1} (eval '(parse-string "{\"a\":1}" true))))))
