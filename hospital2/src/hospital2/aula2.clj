(ns hospital2.aula2
  (:use clojure.pprint)
  (:import (java.text.spi DateFormatSymbolsProvider)))

(defrecord PacienteParticular [id nome nascimento])
(defrecord PacientePlanoDeSaude [id nome nascimento plano])

(defprotocol Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]))

(extend-type PacienteParticular
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]
    (>= valor 50)))

(extend-type PacientePlanoDeSaude
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]
    (let [plano (:plano paciente)]
      (not(some #(= % procedimento) plano)))))

(let [particular (->PacienteParticular 15 "Joao" "27/02/2001")
      plano (->PacientePlanoDeSaude 22 "Luiz" "17/06/2000"
                                    [:raiox :ultrassom])]
  (pprint (deve-assinar-pre-autorizacao? particular :raiox 500))
  (pprint (deve-assinar-pre-autorizacao? particular :raiox 40))
  (pprint (deve-assinar-pre-autorizacao? plano :raiox 500))
  (pprint (deve-assinar-pre-autorizacao? plano :coleta-de-sangue 500)))

(defprotocol Dateable
  (to-ms [this]))

(extend-type java.lang.Number
  Dateable
  (to-ms [this] this))

(pprint (to-ms 56))

(extend-type java.util.Date
  Dateable
  (to-ms [this] (.getTime this)))

(pprint (to-ms (java.util.Date.)))

(extend-type java.util.Calendar
  Dateable
  (to-ms [this] (to-ms (.getTime this))))

(pprint (to-ms (java.util.GregorianCalendar.)))

