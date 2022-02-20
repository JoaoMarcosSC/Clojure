(ns funcoes-primeira-ordem.core)


;;Chamar uma função em outra
 (defn consulta-taxa
  []
  0.20)

;;Maneira 1
(defn imposto-retido
  [salario]
  (if (< salario 1000)
    0
    (* salario (consulta-taxa))))

;;Maneira 2
(defn imposto-retido
  [taxa-padrao salario]
  (if (< salario 1000)
    0
    (* salario taxa-padrao)))

(imposto-retido 0.4 1000)
(imposto-retido (consulta-taxa) 1000)

;;Maneira Correta
(defn imposto-retido
  [consulta-taxa-padrao salario]
  (if (< salario 1000)
    0
    (* salario (consulta-taxa-padrao))))

(imposto-retido consulta-taxa 1000)


;;Taxa fixa
(defn consulta-taxa-fixa
  []
  0.10)

(defn imposto-retido
  [consulta-taxa-padrao salario]
  (if (< salario 1000)
    0
    (* salario (consulta-taxa-padrao))))

(imposto-retido consulta-taxa-fixa 1000)

;;Taxa fixa 2
(defn minha-taxa-padrao
  []
  consulta-taxa-fixa)

(imposto-retido (minha-taxa-padrao) 2000)

;;Taxa fixa com taxa padrão
(defn escolhe-consulta-taxa-padrao
  [ambiente]

  (if ( = ambiente :teste)
  consulta-taxa-fixa
  consulta-taxa))

(escolhe-consulta-taxa-padrao :teste)
(imposto-retido (escolhe-consulta-taxa-padrao :teste) 1000)
(imposto-retido (escolhe-consulta-taxa-padrao :sopa) 1000)

;;Função anonima, maneira 1
(fn [x] (* 2 x))
((fn [x y] (+ x y)) 6 7)

;;Função anonima, maneira 2
(#(* 2 %) 5)
(#(+ % %) 2)

;;Retorna sempre o mesmo valor definido
((constantly 0.2) 1 2 3 4 5 6 7 34526534)

;;Simplificando exemplo anterior com novas técnicas
(imposto-retido (fn [] 0.1) 3000)
(imposto-retido (constantly 0.27) 3000)