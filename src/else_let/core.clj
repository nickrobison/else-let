(ns else-let.core)

; Borrowed from Clojure core, since it's private, I copied.
(defmacro assert-args
  [& pairs]
  `(do (when-not ~(first pairs)
         (throw (IllegalArgumentException.
                  (str (first ~'&form) " requires " ~(second pairs) " in " ~'*ns* ":" (:line (meta ~'&form))))))
       ~(let [more (nnext pairs)]
          (when more
            (list* `assert-args more)))))


(defn else-eval
  "Performs the actual if-else evaluation of the two bindings"
  [fst lst]
  (let [tmp fst]
     (if (nil? tmp)
       lst
       tmp)))

(defn process-else
  "Processes the vector of inputs and returns the form along with the call to evaluate the two bindings"
  [binds]
  (let [bents (partition 3 binds)]
    (reduce (fn [acc bent] (conj acc (first bent) `(else-eval ~(nth bent 1) ~(nth bent 2)))) [] bents)))

(defmacro else-let
  "Evaluates the expressions, in order, and attempts to bind the first form to the variable.
  If the evaluation returns nil, evaluates the second form and binds its value.
  If the evaluation is non-nil, binds the value of the first form.
  If the final form returns nil, then nil is bound."
  [vals & rest]
  (assert-args
    (vector? vals) "a vector for its binding"
    (= 0 (mod (count vals) 3)) "each binding must have exactly 3 forms")
  `(let* ~(process-else vals) ~@rest))
