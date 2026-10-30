(ns music.core
  (:gen-class))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn create-review
  [artist title year rating review]
  {:artist artist
   :title title
   :year year
   :rating rating
   :review review})

 (defn create-playlist
   [playlist-name]
   {:name playlist-name
    :songs []})

(defn add-song-to-playlist
  [playlist song]
  {:name (:name playlist)
   :songs (conj (:songs playlist) song)})

(defn song-count
  [playlist]
  (count (:songs playlist)))