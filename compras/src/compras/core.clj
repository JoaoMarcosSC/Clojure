(ns compras.core)

;;Carrinho de compras
(defn compras
  []
{:tomate {:quantidade 2 :preco 5}
 :arroz {:qunatidade 1 :preco 4}
 :feijao {:quantidade 2 :preco 10}})

(compras)

;;Recuperar um item do mapa
(get (compras) :tomate)
;;ou
(:tomate (compras))

;;Recuperar apenas um valor do mapa
(:preco(:tomate(compras)))