(ns meu-projeto-em-clojure.core-test
  (:require [clojure.test :refer :all]
            [meu-projeto-em-clojure.core :refer :all]))


(deftest teste-test
      (testing "Abaixo ou igaul a 100, retorne 15"
        (is (= 15 (taxa-de-entrega 1)))
        (is (= 15 (taxa-de-entrega 100))))

      (testing " Acima de 100, abaixo de 200, retorne 5"
        (is (= 5 (taxa-de-entrega 100.01)))
        (is (= 5 (taxa-de-entrega 199.9))))

      (testing "Acima de 200 reais, retorne 0"
        (is (= 0 (taxa-de-entrega 200.01)))
        (is (= 0 (taxa-de-entrega 10000000)))))


