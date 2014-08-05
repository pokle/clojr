# Dev process

After making changes, run the following scripts to install a local copy on your computer

	$ ./scripts/build && ./scripts/install

You can then run the samples:

	$ clojr samples/hello.clj
	Hellfjord - watch it!

# Deployment process

- Bump up the version in project.clj AND src/clojr
- commit & push to github
- ./scripts/build
- scp target/dist/pom.xml target/dist/clojr-*.jar clojars@clojars.org:
