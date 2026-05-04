#!/usr/bin/env bash clojr

(clojr/dep cheshire "5.13.0" cheshire.core)

(-> (slurp "https://api.ipify.org?format=json")
    (parse-string true)
    :ip
    println)
