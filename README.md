# Clojr

Clojr is short for Clojure runner.

Use it to run single file Clojure apps. It's much lighter and faster than leiningen for this purpose.

Clojr only requires a unixy system like OS X or Linux with Java installed. It downloads Clojure for you the first time you run it.

[![Clojars Project](http://clojars.org/clojr/latest-version.svg)](http://clojars.org/clojr)

### Mac OS X

    brew tap pokle/docker
    brew install --HEAD clojr

### Linux and other unixes

    wget https://raw.githubusercontent.com/pokle/clojr/master/src/clojr -O /usr/local/bin/clojr
    chmod +x /usr/local/bin/clojr

Optionally install rlwrap - if you want nicer editing in the repl

### Run your single file clojure scripts

    clojr yourscript.clj

### Run a REPL

    clojr

### Hash bangs!

Create a Clojure file starting with a has bang like this:

    #!/usr/bin/env bash clojr
    (println "Hellfjord - watch it!")

And if you called it hello.clj, you can make it executable and run it:

    $ chmod +x hello.clj
    $ ./hello.clj
    Hellfjord - watch it!

### Load adjacent files

Just use the Clojure load function to load other files in directories relative to the inital one. Have a look at the load_hello.clj sample.
