#!/usr/bin/env bash clojr

(clojr/dep cheshire "5.3.1" cheshire.core)

(println (:ip (parse-string (slurp "http://ip.jsontest.com") true)))
