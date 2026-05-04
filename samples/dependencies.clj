#!/usr/bin/env bash clojr

; Download and load the Cheshire json library,
; and use its cheshire.core namespace
(clojr/dep cheshire "5.13.0" cheshire.core)

; use it!
(println
  (parse-string "{\"it\":[\"works\"]}" true))
