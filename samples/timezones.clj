#!/usr/bin/env clojr

(use 'clojr)
(clojr/dep cheshire "5.3.1" cheshire.core)


(def tzf (clojure.java.io/file (__DIR__) "timezones.json"))
; (def timezones (slurp "https://gist.githubusercontent.com/ykessler/3349960/raw/d335629b300f6051f69bcffefe719013a5e6d9a1/timezones")
(def timezones (slurp tzf))

(let [json 			(parse-string timezones true)
	  country-name 	"Australia"
	  country 	 	(first (filter #(= country-name (:group %)) json)) 
	  zones      	(:zones country)
	  zone-names    (map :value zones)]
	 (println (clojure.string/join "\n" zone-names)))
