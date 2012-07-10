# seqsy

Seqsy is really a single function, seqsy-print, which expects a 2D
sequence of sequences and prints it to your REPL with the columns
evenly space, so that you can read it. That is all.

## Usage

The idea is that you add seqsy to your Leiningen 2 `user` profile, so
that you always have it handy while you're REPLing to print tabular
structures nicely.

So, with Leiningen 2, I recommend adding something like this 
to `~/.lein/profiles.clj`:

    {:user
     {:dependencies [[seqsy "0.1.0"]]}}


## License

Copyright © 2012 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
