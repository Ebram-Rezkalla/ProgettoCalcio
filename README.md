# ProgettoCalcio
## INTRODUZIONE ALL'APPLICAZIONE
### L'applicazione sviluppata nell'ambito di questo progetto permette di studiare le competizioni di calcio di 3 paesi l'Italia, la Francia e la Germania, fornendo informazioni generali di tutte le competizioni e specifiche per ogni competizione generando anche delle statistiche generali e statistiche in base alla competizione e filtrarle utilizzando l'API Reference (football-data).
## UML USE CASE DIAGRAM

![ProgettoCalcioUseCaseDiagram](https://user-images.githubusercontent.com/75068172/122418475-85abd700-cf8a-11eb-8872-1264595af218.jpg)

## DIAGRAMMA DI CLASSI

![ProgettoCalcioClassDiagram](https://user-images.githubusercontent.com/75068172/122463997-996d3280-cfb6-11eb-8df2-80d7dbe363dd.jpg)

## DIAGRAMMI DI SEQUENZE

Diagramma/ Competizione

![Competizione_SEQUENCE_DIAGRAM](https://user-images.githubusercontent.com/75068172/122466754-ffa78480-cfb9-11eb-8396-ca4c63ee2e38.jpg)

Diagramma/ Stats

![Stats_SEQUENCE_DIAGRAM](https://user-images.githubusercontent.com/75068172/122470519-70e93680-cfbe-11eb-9a6e-2af71609dedf.jpg)

Digragramma/ Filter

![Filter_SEQUENCE_DIAGRAM](https://user-images.githubusercontent.com/75068172/122470579-82324300-cfbe-11eb-8208-11cf8a3c2607.jpg)

## SCHEMA RIEPILOGATIVO DELLE ROTTE
| TIPO     | ROTTA |
| -------  | ---   | 
| GET      | Competizioni  | 
| GET      | Competizione   |
|  GET| Stats |
| POST | Filter | 
| GET | StatsComp | 
| POST | FilterComp | 

## Get/Competizioni

La rotta getCompetizioni restituisce all’utente le informazioni generali di tutte le competizioni dell’ultima stagione.

Il risultato riportato è in formato JSON e ciascuna competizione è descritta dai seguenti campi:

* id: Id della competizione
* vincitore: Vincitore della stagione
* nome_Competizione: Nome della Competizione
* data_Fine: Data di termine della stagione  
* data_Inizio: Data inizio della stagione 
* nome_Paese: Nome del paese

### Eempio chiamata su Postman

![competizioni](https://user-images.githubusercontent.com/85204495/122292049-7460bd00-ceed-11eb-910f-4a2cc869e0ea.PNG)


## GET/Competizione 

La rotta getCompetizione restituisce all’utente tutte le informazioni della competizione scelta mettendo come param la chiave (id) e il valore id della competizione richiesta (2019 Italia, 2015 Francia e 2002 Germania).

### Eempio chiamata su Postman

![competizione2019](https://user-images.githubusercontent.com/85204495/122291491-c7864000-ceec-11eb-88ea-b6ae796cccee.PNG)

## GET/Stats

La rotta getStats restituisce all’utente le statistiche generali di tutte le competizioni.

Il risultato riportato è in formato JSON è descritto dai seguenti campi:

* massimo numero squadre
* minimo numero squadre
* medio numero squadre
* media stagioni salvate
* media durata stagione mesi
* media resto durata stagione giorni

### Eempio chiamata su Postman

![statsgenerali](https://user-images.githubusercontent.com/85204495/122292258-b25de100-ceed-11eb-978d-73974e2e80c7.PNG)

## POST/Filter

La rotta postFilter filtra le statistiche generali per una o due competizioni a scelta inserendo dei parametri di filtraggio in input che verranno inseriti un body JSON (id1 rappresenta la prima competizione e id2 rappresenta la seconda).

### Eempio chiamata su Postman

![filter](https://user-images.githubusercontent.com/85204495/122292670-2304fd80-ceee-11eb-912c-d3585f0c54cd.PNG)

## GET/StatsComp

La rotta geStatsComp restituisce all’utente le statistiche di una specifica competizione in base all'id per scegliere la competizione si mette come param la chiave (id) e il valore id della competizione richiesta (2019 Italia, 2015 Francia e 2002 Germania).

Il risultato riportato è in formato JSON è descritto dai seguenti campi:

* squadra maggior vincite
* squadra miglior difesa
* squadra miglior differenza goal
* numero stagione salvate
* squadra miglior attacco
* squadra maggior perdite

### Eempio chiamata su Postman

![statscomp](https://user-images.githubusercontent.com/85204495/122292779-42038f80-ceee-11eb-848d-f057b8f782dd.PNG)

## POST/FilterComp

La rotta postFilterComp filtra le statistiche di una specifica competizione a scelta inserendo dei parametri di filtraggio in input che verranno inseriti un body in formato JSON.
Il filtraggio si fa  in base a : 

* id della competizione
* tipo della partita 
* numero di squadre
* la posizione delle squadre prime o ultime 
   
### Eempio chiamata su Postman

![filtcomp](https://user-images.githubusercontent.com/85204495/122292928-6a8b8980-ceee-11eb-9b6c-3c91d3f5ef5c.PNG)

## ECCEZIONI

### JSONexception

Questa eccezione e un overwrite dell’eccezione HttpRequestMethodNotSupportedException che viene lanciata quando e’ richiesto un metodo non consentito per una determinata rotta.

### Esempio

![tiporotta](https://user-images.githubusercontent.com/85204495/122457653-c7e31180-cfa6-11eb-87f4-cfe200ffed61.PNG)

### NotFound

Viene lanciata quando viene inserito un parametro non corretto o nullo.

### Esempio

Quando l'utente mette un id non corretto.

![idnoncorretto](https://user-images.githubusercontent.com/85204495/122294428-f05c0480-ceef-11eb-9e3a-ae8578233b09.PNG)

Quando l'utente non mette l'id.

![idnoninserito](https://user-images.githubusercontent.com/85204495/122294495-02d63e00-cef0-11eb-8ee6-545b8c4d8626.PNG)

### BodyException

Viene lanciata quando viene inserito una chiave json body che non esiste.

### Esempio

Quando l'utente sbaglia la scrittura di una delle chiavi.

![errorebody](https://user-images.githubusercontent.com/85204495/122294592-1da8b280-cef0-11eb-9e1f-90a7c937a4e4.PNG)

Quando l'utante mette un parametro non corretto.

![letteranoncorretta](https://user-images.githubusercontent.com/85204495/122294749-4d57ba80-cef0-11eb-8e45-11640c7efe7c.PNG)

## JUINT TEST

Nell'applicazione è stata implementata una sezione di testing attraverso l'utilizzo di JUNIT.

### NotFoundtest:
Verifica il Lancio dell'eccezione in caso viene inserito un id non valido.

### GetNumbertest:
Verifica codice competizione.

## Software utilizzati:

* Eclipse: Ambiente di sviluppo
* Postman: Ambiente di sviluppo API per effettuare richieste
* Juint: Per esguire il test
* Springboot: Framework per sviluppo di applicazioni in Java
* Drawio : Software per la realizzazione dei diagrammi UML
____________________________________________________

Grazie per l'attenzione 


