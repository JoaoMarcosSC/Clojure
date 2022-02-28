(ns hospital.aula3
  (:use [clojure pprint])
  (:require [hospital.model :as h.model])
  (:require [hospital.logic :as h.logic]))

(defn testa-atom []
  (let [hospital-santa (atom { :espera h.model/fila_vazia})]
    (println hospital-santa)
    (pprint (deref hospital-santa))

    (swap! hospital-santa assoc :laboratorio1 h.model/fila_vazia)
    (pprint hospital-santa)

    (swap! hospital-santa assoc :laboratorio2 h.model/fila_vazia)
    (pprint hospital-santa)

    (swap! hospital-santa update :laboratorio1 conj "1111")
    (pprint hospital-santa)
  ))
;;(testa-atom)

(defn chega-em-malvado!  [hospital pessoa]
  (swap! hospital h.logic/chega-em-pausado-logando :espera pessoa)
  (println "apos inserir" pessoa))

(defn simula-um-dia-em-paralelo
  []
  ; MUITO CLARO o problema de variavel global (simbolo do namespace) compartilhado entre threads
  (let [hospital (atom (h.model/novo-hospital))]
    (.start (Thread. (fn [] (chega-em-malvado! hospital"111"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital"222"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital"333"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital"444"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital"555"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital"666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))


(simula-um-dia-em-paralelo)