(ns music.core-test
  (:require [midje.sweet :refer :all]
            [music.core :refer :all]))
    (fact
      (create-review "Queen" "Bohemian Rhapsody" 1975 10 "Amazing song!")
      =>
      {:artist "Queen"
       :title "Bohemian Rhapsody"
       :year 1975
       :rating 10
       :review "Amazing song!"})
    (fact
      (create-review "ABBA" "Dancing Queen" 1976 9 "Great!")
      =>
      {:artist "ABBA"
       :title "Dancing Queen"
       :year 1976
       :rating 9
       :review "Great!"})
    (fact
      (create-playlist "Favorites")
      =>
      {:name "Favorites"
       :songs []})
    (fact
      (song-count (create-playlist "Rock"))
      =>
      0)
    (fact
      (add-song-to-playlist
        (create-playlist "Rock")
        "Bohemian Rhapsody")
      =>
      {:name "Rock"
       :songs ["Bohemian Rhapsody"]})
    (fact
      (add-song-to-playlist
        (add-song-to-playlist
          (create-playlist "Rock")
          "Bohemian Rhapsody")
         "We Will Rock You")
      =>
      {:name "Rock"
       :songs ["Bohemian Rhapsody" "We Will Rock You"]})
    (fact
      (song-count
        {:name "Rock"
         :songs ["Song 1" "Song 2" "Song 3"]})
      =>
      3)
    (fact
      (song-count {:name "Empty" :songs []})
      =>
      0)
      (fact
        (search-by-artist
          [{:artist "Queen" :title "Bohemian Rhapsody" :year 1975 :rating 10 :review "Amazing song!"}
           {:artist "ABBA" :title "Dancing Queen" :year 1976 :rating 9 :review "Great!"}
           {:artist "Queen" :title "Don't Stop Me Now" :year 1978 :rating 8 :review "Classic!"}]
          "Queen")
        =>
        [{:artist "Queen" :title "Bohemian Rhapsody" :year 1975 :rating 10 :review "Amazing song!"}
         {:artist "Queen" :title "Don't Stop Me Now" :year 1978 :rating 8 :review "Classic!"}])

      (fact
        (search-by-artist
          [{:artist "Queen" :title "Bohemian Rhapsody" :year 1975 :rating 10 :review "Amazing song!"}]
          "Beatles")
        =>
        [])

      (fact
        (filter-high-ratings
          [{:artist "Queen" :title "Bohemian Rhapsody" :year 1975 :rating 10 :review "Amazing song!"}
           {:artist "ABBA" :title "Dancing Queen" :year 1976 :rating 9 :review "Great!"}
           {:artist "Queen" :title "Don't Stop Me Now" :year 1978 :rating 8 :review "Classic!"}]
          9)
        =>
        [{:artist "Queen" :title "Bohemian Rhapsody" :year 1975 :rating 10 :review "Amazing song!"}
         {:artist "ABBA" :title "Dancing Queen" :year 1976 :rating 9 :review "Great!"}])

      (fact
        (filter-high-ratings
          [{:artist "ABBA" :title "Dancing Queen" :year 1976 :rating 9 :review "Great!"}]
          10)
        =>
        [])
       (fact
         (calculate-average-rating
           [{:artist "Queen" :title "Bohemian Rhapsody" :year 1975 :rating 10 :review "Amazing song!"}
            {:artist "ABBA" :title "Dancing Queen" :year 1976 :rating 9 :review "Great!"}
            {:artist "Queen" :title "Don't Stop Me Now" :year 1978 :rating 8 :review "Classic!"}])
         =>
         9)

       (fact
         (calculate-average-rating [])
         =>
         0)
