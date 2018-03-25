(ns else-let.core-test
  (:require [clojure.test :refer :all]
            [else-let.core :refer :all]))

(deftest first-nil
  (testing "If first form is nil."
    (is (=
          1
          (else-let [x nil 1] x)))))

(deftest second-nil
  (testing "If second form is nil."
    (is (=
          1
          (else-let [x 1 nil] x)))))

(deftest all-nil
  (testing "If all forms are nil."
    (is (nil?
          (else-let [x nil nil] x)))))

(deftest nested-let
  (testing "We can use nested let values"
    (is (=
          18
          (else-let [x nil 17
                     y (+ x 1) "other"] y)))))

(deftest map-keys
  (testing "Map key destructuring works correctly"
    (is (=
          20
          (let [test-map {:key1 17}]
            (else-let [tmp (:key1 test-map) 0
                       y (:key2 test-map) 3]
                      (+ y tmp)))))))
