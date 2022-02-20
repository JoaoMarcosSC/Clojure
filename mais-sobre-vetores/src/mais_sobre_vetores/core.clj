(ns mais-sobre-vetores.core)

;; Adicionar a um vetor
(conj ["batata" "arroz"] "banana")

;; Remover de um vetor
(pop ["batata" "arroz" "banana"])

(defn desistir-da-ultima-compra
  [compras]
  (pop compras))

(desistir-da-ultima-compra ["batata" "arroz" "banana"])

;;Primeiro Nome
(defn imprime-primeiro-nome
  [nome]
  (println (get nome 0 "Desconhecido")))

(imprime-primeiro-nome ["Marcio" "João" "Lucas"])

;;Terceiro Nome
(defn imprime-terceiro-nome
  [nome]
  (println (get nome 2 "Desconhecido")))

(imprime-terceiro-nome ["Marcio" "João" "Lucas"])

;;Mensagem para número acima da quantidade de vetores
(defn imprime-nome-desconhecido
  [nome]
  (println (get nome 3 "Desconhecido")))

(imprime-nome-desconhecido ["Marcio" "João" "Lucas"])

;; Substituir posição de um vetor
(defn substituir-primeiro-nome
  [nome novo-primeiro-nome]
  (assoc nome 0 novo-primeiro-nome))

(substituir-primeiro-nome ["Marcio" "João" "Lucas"] "José")