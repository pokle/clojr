# circ

Run single file clojure scripts. Must neater than creating a whole new leiningen project.

### Install

    wget https://raw.githubusercontent.com/pokle/circ/master/circ -O /usr/local/bin/circ
    chmod +x /usr/local/bin/circ

### Run your single file clojure scripts

    circ yourscript.clj

### Hash bangs!

Create a Clojure file starting with a has bang like this:

    #!/usr/bin/env bash circ
    (println "Hellfjord - watch it!")

And if you called it hello.clj, you can make it executable and run it:

    $ chmod +x hello.clj
    $ ./hello.clj
    Hellfjord - watch it!

### Load adjacent files

Just use the Clojure load function to load other files in directories relative to the inital one. Have a look at the load_hello.clj sample.
