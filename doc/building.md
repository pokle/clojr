# Dev process

After making changes, run the following scripts to install a local copy on your computer

	$ ./scripts/build && ./scripts/install

You can then run the samples:

	$ clojr samples/hello.clj
	Hello ()

By default the launcher is installed to `/usr/local/bin/clojr`. To install
elsewhere, set `PREFIX`:

	$ PREFIX=$HOME/.local ./scripts/install

# Deployment process

- Bump the version in `project.clj` (the build script propagates it into the launcher)
- Commit & push to GitHub
- `./scripts/build`
- `./scripts/deploy` (publishes to Clojars via `lein deploy clojars`)
