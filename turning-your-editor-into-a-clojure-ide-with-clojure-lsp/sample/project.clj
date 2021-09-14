(defproject sample "0.0.1"
  :description "some sample"
  :url ""
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/data.json "2.4.0"]
                 [http-kit/http-kit "2.5.3"]]
  :main sample.main
  :plugins [[com.github.clojure-lsp/lein-clojure-lsp "1.0.3"]]
  :aliases {"clean-ns" ["clojure-lsp" "clean-ns" "--dry"]})
