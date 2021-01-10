# BWI-Coding_Challenge
##Nutzung:
- Betriebssystem: Windows
- Programm IntelliJ 2020.3
- Projekt SDK: 11.0.4.

##Ausführen:
1. Java-Datei öffnen
2. Main Methode in Klasse Main ausführen

##Inhalt der Klassen:
Main-Klasse: 
- alle Variablen
- Produkt Liste wird eingelesen (hier sind die verwendeten Produkte einles- und beartbeitbar)
- Sortier-Algorithmus (Produkte werden nach Verhähltnis von Gewicht zu Nutzen sortiert)
- Transporter werden eingelsen
- für jeden transporter wird der Greedy-Algorithmus einzeln aufrgerufen
- Greedy-Algorithmus:
1. Überprüfen, ob aktuelles Gewicht unter maximal möglichem Gewicht liegt und ob das letzte Element der Liste noch nicht erreicht ist 
2. Überprüfen, ob das Produkt noch Verfügbar ist
3. Überprüfen, ob die Menge des aktuellen Produkts 0 oder ob man das Maximalgewicht mit dem neuen einladen des Produkts überschreitet
4. ist dies der Fall --> Produktname, eingeladene Menge und Taransporter in den es eingeladen wird, wird in Konsole ausgegeben, Verfügbarkeit wird für den aktuellen Tarnsporter auf false gesetzt
5. sonst Überprüfen, ob dazukommende Gewicht mit dem aktuellen Gewicht noch nicht das Maximalgewicht überschreitet
6. in diesem Fall, werden Gewicht, Nutzwert und Menge des aktullen Produkt auf den Gesamtwert des Transporter addiert
7. schließlich wird der Gesamtnutzen des Transporter zurückgegeben
- Transportliste und Gesamtnutzen des Transporters werden in KJonsole ausgegeben
- Gesamtnutzen wird in Konsole ausgegeben

Product-Klasse:
- Grundlegende Parameter für die Prdukte (Name, Menge, Gewicht, Nutzwert, noch Verfügbar?)
- für alle Prarameter get und set Methode um Werte von den Prdoukten zu bekomen und um diese zu ändern


##Algorthimuswahl:
Es wurde ein Greedy-Algorithmus gewählt, da dieser einfach umzusetzten ist, und schnell ein optimales Ergebiss liefert. Durch die vorsortierung der Lsite wird das Problem des Greedy-Algoritmuses kompensiert, dass er sonst immer ein lokales Optimum wählt. So wird hier ein gloabels Optimum zurückgegeben.

##Nutzwerte:
- Transporter 1: 44764
- Transporter 2: 29116
- Gesamt: 73880
