# BWI-Coding_Challenge
## Nutzung:
- Betriebssystem: Windows
- Programm IntelliJ 2020.3
- Projekt SDK: 11.0.4.

## Ausführen:
1. Java-Datei öffnen
2. Main Methode in Klasse Main ausführen

## Inhalt der Klassen:
Main-Klasse: 
- alle Variablen
- Produkt Liste wird eingelesen (hier sind die verwendeten Produkte einlese- und bearbeitbar)
- Sortier-Algorithmus (Produkte werden nach Verhältnis von Gewicht zu Nutzen sortiert)
- Transporter werden eingelesen
- für jeden Transporter wird der Greedy-Algorithmus einzeln aufgerufen
- Greedy-Algorithmus:
1. Überprüfen, ob aktuelles Gewicht unter maximal möglichem Gewicht liegt und ob das letzte Element der Liste noch nicht erreicht ist 
2. Überprüfen, ob das Produkt noch Verfügbar ist
3. Überprüfen, ob die Menge des aktuellen Produkts 0 oder ob man das Maximalgewicht mit dem neuen Einladen des Produkts überschreitet
4. ist dies der Fall --> Produktname, eingeladene Menge und Transporter, in den es eingeladen wird, wird in Konsole ausgegeben, Verfügbarkeit wird für den aktuellen Transporter auf false gesetzt
5. sonst überprüfen, ob dazukommende Gewicht mit dem aktuellen Gewicht noch nicht das Maximalgewicht überschreitet
6. in diesem Fall, werden Gewicht, Nutzwert und Menge des aktuellen Produkts auf den Gesamtwert des Transporter addiert
7. schließlich wird der Gesamtnutzen des Transporters zurückgegeben
- Transportliste und Gesamtnutzen des Transporters werden in Konsole ausgegeben
- Gesamtnutzen wird in Konsole ausgegeben

Product-Klasse:
- Grundlegende Parameter für die Produkte (Name, Menge, Gewicht, Nutzwert, noch Verfügbar?)
- für alle Parameter get und set Methode, um Werte von den Produkten zu bekommen und um diese zu ändern


## Algorithmuswahl:
Es wurde ein Greedy-Algorithmus gewählt, da dieser einfach umzusetzen ist, und schnell ein optimales Ergebnis liefert. Durch die Vorsortierung der Liste wird das Problem des Greedy-Algorithmuses kompensiert, dass er sonst immer ein lokales Optimum wählt. So wird hier ein globales Optimum zurückgegeben.

## Nutzwerte:
- Transporter 1: 44764
- Transporter 2: 29116
- Gesamt: 73880
