# Clojr

Clojr is short for Clojure runner.

I've always wanted to write single file utility Clojure scripts like you can with shell scripts, ruby, python, perl, etc. Now you can with Clojr.


### Installation - Unixes

Download the Clojr shell script

    wget https://raw.githubusercontent.com/pokle/clojr/master/src/clojr -O /usr/local/bin/clojr
    chmod +x /usr/local/bin/clojr

Also install [Java](http://java.sun.com), and if you use the repl a lot - install rlwrap (to get history and fancy editing)

### Installation - Mac OS X

    brew tap pokle/docker
    brew install --HEAD clojr

### Running

The first time your run clojr, it will download its Clojure dependencies.

#### Run your single file clojure scripts

    clojr yourscript.clj

#### Run a REPL

    clojr

#### Hash bangs!

Create a Clojure file starting with a has bang like this:

    #!/usr/bin/env bash clojr
    (println "Hellfjord - watch it!")

And if you called it hello.clj, you can make it executable and run it:

    $ chmod +x hello.clj
    $ ./hello.clj
    Hellfjord - watch it!

#### Load adjacent files

Just use the Clojure load function to load other files in directories relative to the inital one. Have a look at the load_hello.clj sample.

#### Load maven / clojars dependencies

You can download maven or clojars libraries with the clojr/dep macro:

    (clojr/dep cheshire) ; Loads the latest version of cheshire
    (use 'cheshire.core) ; Bring it into our namespace
    (parse-string "{}")  ; => {}

You can specify a version like this:

    (clojr/dep cheshire "5.3.1")

And roll in the '(use 'cheshire.core)' like this:

    (clojr/dep cheshire "5.3.1" cheshire.core)

### Development

Read doc/building.md
