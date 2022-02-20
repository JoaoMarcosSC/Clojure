(ns filter-map-reduce.reduce)

;;Recebe um vetor de idades e retorna a soma

(defn soma-das-idades
      [idades]
      (reduce + idades))

(soma-das-idades [2 3 4 6 7])