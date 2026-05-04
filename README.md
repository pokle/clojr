# Clojr

Clojr is short for Clojure runner.

I've always wanted to write single file utility Clojure scripts like you can with shell scripts, ruby, python, perl, etc. Now you can with Clojr.

### Quick install

You need [Java](https://adoptium.net/) on your `PATH`. Then drop the launcher into a directory on your `PATH`:

```sh
curl -fsSL https://raw.githubusercontent.com/pokle/clojr/v0.6.2/src/clojr -o ~/.local/bin/clojr
chmod +x ~/.local/bin/clojr
```

(Substitute `/usr/local/bin` for `~/.local/bin` if you prefer it system-wide; `/usr/local/bin` may need `sudo`.)

The first run downloads the runtime jar from Clojars into `~/.clojr`.

### Running

#### Run your single-file Clojure scripts

    clojr yourscript.clj

#### Run a REPL

    clojr

#### Hash bangs!

Create a Clojure file starting with a hash bang like this:

```clojure
#!/usr/bin/env clojr
(println "Hello" *command-line-args*)
```

And if you called it `hello.clj`, you can make it executable and run it:

    $ chmod +x hello.clj
    $ ./hello.clj world
    Hello (world)

#### Load adjacent files

Just use the Clojure `load` function to load other files in directories relative to the initial one. Have a look at the `samples/load_hello.clj` sample.

#### Load Maven / Clojars dependencies

You can download Maven or Clojars libraries with the `clojr/dep` macro:

    (clojr/dep cheshire)         ; Loads the latest version of cheshire
    (use 'cheshire.core)         ; Bring it into our namespace
    (parse-string "{}")          ; => {}

You can specify a version like this:

    (clojr/dep cheshire "5.13.0")

And roll in the `(use 'cheshire.core)` like this:

    (clojr/dep cheshire "5.13.0" cheshire.core)

### Development

Read [doc/building.md](doc/building.md).
