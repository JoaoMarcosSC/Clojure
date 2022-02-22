(ns vendas.loja1
  (:require [vendas.db :as v.db]
            [vendas.logic :as v.logic]))

(println(v.db/todos-os-pedidos))

(let [pedidos (v.db/todos-os-pedidos)
      resumo (v.logic/resumo-por-usuario (v.db/todos-os-pedidos))]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo)))

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       v.logic/resumo-por-usuario
       (sort-by :preco-total)))

(let [pedidos (v.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo))

(defn top-2 [resumo]
  (take 2 resumo))

(let [pedidos (v.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Top-2" (top-2 resumo))
(println "take" (take 2 resumo)))

(let [pedidos (v.db/todos-os-pedidos)
     resumo (resumo-por-usuario-ordenado pedidos)]
  (println "500>" (filter #(> (:preco-total %) 500) resumo))
  (println "some" (some #(> (:preco-total %) 500) resumo))
  )