(ns filter-map-reduce.filter)

;;Criar uma função que retorne quantos alunos estão no quinto ano

;;Tudo que for diferente de 5 retornara false e 5 retornara true
(defn esta-no-quinto-ano?
  [ano]
  (= ano 5))

(defn quantidade-estudantes-no-quinto-ano
  [estudantes]
  (count(filter esta-no-quinto-ano? estudantes)))

(quantidade-estudantes-no-quinto-ano [5 6 7 5])

;;Maniera sem a função esta-no-quinto-ano?
(defn quantidade-estudantes-no-quinto-ano
  [estudantes]
  (count (filter (fn [ano] ( = 5 ano)) estudantes)))

(quantidade-estudantes-no-quinto-ano [5 6 7 5])
