#!/usr/bin/env bash clojr

(clojr/dep cheshire "5.3.1" cheshire.core)

(-> (slurp "http://ip.jsontest.com")
    (parse-string true)
    :ip
    println)
