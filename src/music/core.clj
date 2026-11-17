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

 (defn search-by-artist
   [reviews artist-name]
   (filter (fn [review] (= (:artist review) artist-name)) reviews))

 (defn filter-high-ratings
    [reviews min-rating]
    (filter (fn [review] (>= (:rating review) min-rating)) reviews))

  (defn calculate-average-rating
    [reviews]
    (if (empty? reviews)
      0
      (/ (reduce + (map :rating reviews))
         (count reviews))))