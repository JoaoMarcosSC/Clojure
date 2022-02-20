(ns tipos.core)

;;Somar
(defn soma
   [x y]
   (+ x y))

 (defn imprime-soma
   []
   (println (soma 2 2)))

;;Identificar tipos
(type 10)
(type 10.0)
(class 10)
(type(/ 10 3))
(type (* 3 (/ 10 3)))
(type 10N)
(type 10M)
(type "João")
(type nil)
(type [])
(type println)
