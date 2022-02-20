(ns banco.imposto.logic-test
  (:require [clojure.test :refer :all]
            [banco.imposto.logic :refer :all]))

(deftest imposto-retido-da-fonte
  (testing "Abaixo de 1000 reias não cobrar imposto"
    (is (= 0 (imposto-retido-fonte 1)))
    (is (= 0 (imposto-retido-fonte 999.99))))
  (testing "Valor acima de 1000 reais, cobrar 10% de imposto"
  (is (= 100.00 (imposto-retido-fonte 1000)))))
