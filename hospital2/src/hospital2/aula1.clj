(ns hospital2.aula1
  (:use clojure.pprint))

(defn adiciona-paciente
  [pacientes paciente]
  (if-let [id (:id paciente)]
       (assoc pacientes (:id paciente) paciente))
  )

(defn testa-uso-de-pacientes []
  (let [pacientes {}
        joao { :id 15 :nome "Joao" :nascimento "27/02/2001"}
        paulo { :nome "Paulo" :nascimento "15/03/1993"}
        julia { :id 18 :nome "Julia" :nascimento "21/03/2002"}]
    (pprint (adiciona-paciente pacientes joao))
    (pprint (adiciona-paciente pacientes paulo))
    (pprint (adiciona-paciente pacientes julia))))

;;(testa-uso-de-pacientes)

(defrecord Paciente [id nome nascimento])

(pprint (->Paciente 15 "Joao" "27/02/2001"))