(ns reveal.core
  (:require-macros [hiccups.core :as hiccups :refer [html]])
  (:require [clojure.string :refer [join]]
            [goog.dom :as gdom]
            [hiccups.runtime :as hiccupsrt]
            [reveal.slides :as slides]))


;; When changing comments, you manually need to refresh your browser
(def options #js {:controls    true
                  :progress    true
                  :transition  "fade"                    ; e.g. none/fade/slide/convex/concave/zoom
                  :slideNumber false})



;;;; You do not need to change anything below this comment

(defn convert
  "Get list of all slides and convert them to html strings."
  []
  (let [slides (slides/all)]
    (join (map #(html %) slides))))

(defn main
  "Get all slides, set them as innerHTML and reinitialize Reveal.js"
  []
  (set! (.. (.getElementById js/document "slides") -innerHTML) (convert))
  (.initialize js/Reveal options)
  (.setState js/Reveal (.getState js/Reveal)))

(main)

(defn theme [new-theme]
  (let [doc js/document
        theme (.getElementById js/document "theme")
        head (.-head doc)
        base "bower_components/reveal.js/css/theme/"
        link (.createElement doc "link")
        link-url (str base new-theme ".css")]
    (set! (.-rel link) "stylesheet")
    (set! (.-href link) link-url)
    (set! (.-id link) "theme")
    (print theme)
    (.appendChild head link)))

(defn on-js-reload [])
  ;(theme "black"))
  ;(main))
