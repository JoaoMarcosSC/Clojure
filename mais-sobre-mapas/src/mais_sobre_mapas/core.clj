(ns mais-sobre-mapas.core)

;;Adicionar
(conj [1 2 3 4] 5)

;;Excluir o ultimo elemento
(pop [1 2 3])

;;Retornar ultimo elemento
(peek [1 2 3])


;;Editar mapas
(defn compras
  []
  {:tomate {:quantidade 2, :preco 5}
   :arroz {:quantidade 1, :preco 4}
   :feijao {:quantidade 2, :preco 10}})

(compras)

;;Maneira 1
(conj (compras) {:alface {:quantidade 2, :preco 8}})

;;;Maneira 2 - Associar
(assoc (compras) :alface {:quantidade 2, :preco 8})

;;Desassociar
(dissoc (compras) :tomate)

;;Atualizar valores - Maneira 1
(assoc (compras) :tomate {:quantidade 3, :preco 6})

;;Atualizar valores - Maneira 2
(update {:nome "João", :idade 39} :idade inc)

;;Mostra o número sucessor
(inc 39)

;;Atualizar chaves de um mapa
(update-in (compras) [:tomate :preco] * 2)



