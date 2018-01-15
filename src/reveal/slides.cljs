(ns reveal.slides)

(def slide-1
  [:section
   [:h1 "计算机科学的发展趋势"]
   [:h3 "如何使用Clojure来写PPT"]
   [:pre 
    [:code {:class "javascript"}
     "function trimLineBreaks(input) {
			var lines = input.split('\n');

			// Trim line-breaks from the beginning
			for (var i = 0; i < lines.length; i++) {
				if (lines[i].trim() === '') {
					lines.splice(i--, 1);
				} else break;
			}

			// Trim line-breaks from the end
			for (var i = lines.length-1; i >= 0; i--) {
				if (lines[i].trim() === '') {
					lines.splice(i, 1);
				} else break;
			}

			return lines.join('\n');
		}"]]
   [:p "基于开源"
    [:a {:href "http://lab.hakim.se/reveal-js/"} "reveal.js"]]])

(def slide-2
  [:section
   [:section
    [:h2 "Vertical Slides"]
    [:p "Generate your slides "
     [:a {:href "https://github.com/teropa/hiccups"} "with Hiccups"]]]
   [:section
    [:h2 "Tutorial"]
    [:p "Watch the full tutorial of reveal.js "
     [:a {:href "https://github.com/hakimel/reveal.js/blob/master/demo.html"} "on this site"]]]])

(defn all
  "Add here all slides you want to see in your presentation."
  []
  [slide-1
   slide-2])
