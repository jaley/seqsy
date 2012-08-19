# seqsy

Seqsy is really a single function, `seqsy-print`, which expects a 2D
sequence of sequences and prints it to your REPL with the columns
evenly space, so that you can read it. 

There's also `seqsy-table`, which tabulates a sequence of maps, using
the keys as headings. Handy for printing queries from Mongo or similar.

That is all.

## Usage

The idea is that you add seqsy to your Leiningen 2 `dev` profile, so
that you always have it handy while you're REPLing to print tabular
structures nicely.

So, with Leiningen 2, I recommend adding something like this 
to `~/.lein/profiles.clj`:

    {:dev
     {:dependencies [[seqsy "0.2.0"]]}}


## License

Copyright © 2012 James Aley

Distributed under the Eclipse Public License, the same as Clojure.
