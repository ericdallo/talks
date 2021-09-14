(ns sample.github-api
  (:require
   [clojure.data.json :as json]
   [clojure.string :as string]
   [clojure.walk :as walk]
   [org.httpkit.client :as http]
   [clojure.set :as set])
  (:import
   [java.util Date]))

(def base-api-url
  "https://trendings.herokuapp.com")

(def repo-api-url
  (str base-api-url "/repo"))

(def developer-api-url
  (str base-api-url "/developer"))

(defn ^:private request [url language]
  (-> {:url url
       :method :get
       :query-params {:lang language
                      :since "daily"}}
      http/request
      deref
      :body
      json/read-str
      walk/keywordize-keys
      :items))

(defn fetch-trending-repos [language]
  (request repo-api-url language))

(defn fetch-trending-developers [language]
  (request developer-api-url language))
