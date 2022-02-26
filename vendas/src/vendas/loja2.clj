(ns vendas.loja2
  (:require [vendas.db :as v.db]
            [vendas.logic :as v.logic]))

(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))


(let [pedidos (v.db/todos-os-pedidos)
      resumo (v.logic/resumo-por-usuario pedidos)]
     (println "keep" (keep gastou-bastante?) resumo))

;; A sequencia não esta sendo "gulosa" (eager)
(let [sequencia (range 100000000000)]
  (println(take 2 sequencia)))

(defn filtro1
  [x]
  (println "filtro1" x)
  x)

(println (map filtro1 (range 10)))

(->> (range 50)
     (map filtro1)
     println)