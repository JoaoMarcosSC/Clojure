(ns filter-map-reduce.map)

;;Função que retorne tamanho médio dos nomes

(defn tamanho-medio-dos-nomes
  [nomes]
  (/ (reduce + (map count nomes)) (count nomes)))

(tamanho-medio-dos-nomes ["Joao" "Marcio"])