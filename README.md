# rhinozelfant
Projekt im Rahmen des Bundeswettbewerbs Informatik <br>
http://www.bundeswettbewerb-informatik.de/aktuell/35-bwinf/


Überlegungen für einen besseren Kern-Algorythmus:
- Jedes Pixel der Reihe nach durchgehen.
- Bei jedem Pixel schauen, ob ein gleicher in der Nähe ist.
- Wenn nein, dann zum nächsten Pixel.
- Wenn ja, dann bei diesem Pixel schauen, ob einer in der Nähe ist und so weiter, bis kein gleicher mehr in der Nähe ist.
- Immer wenn mindestens ein gleicher Pixel gefunden wurde, Eintrag in Liste, mit Koordinaten des Start-Pixels und der Anzahl der zusammenhängenden Pixel
- größte zusammenhängende Anzahl von Pixeln auswählen und weiß färben.
