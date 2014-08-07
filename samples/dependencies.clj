#!/usr/bin/env bash clojr

; Download and load the Cheshire json library
(clojr/dependencies '[[cheshire "LATEST"]])

; Bring it into this namespace
(use 'cheshire.core)

; use it!
(println
  (parse-string "{\"it\":[\"works\"]}" true))
