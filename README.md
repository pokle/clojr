# circ

Run single file clojure scripts. 

### Install

    wget https://raw.githubusercontent.com/pokle/circ/master/circ -O /usr/local/bin/circ
    chmod +x /usr/local/bin/circ

### Run your single file clojure scripts

    circ yourscript.clj

### Run your single file clojure scripts like a shell script

When you write a little Clojure script, make sure the first line looks like this (sample.clj):

    #!/usr/bin/env bash circ
    
    (println "Hellsfjord - watch it!")
    
Make sure it's executable, and then just run it:

    $ ./sample.clj
    Hellsfjord - watch it!


