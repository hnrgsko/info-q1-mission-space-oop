# Mission Space – OOP in Java

Materialien für den Q1-Lernpfad **Mission Space** zur objektorientierten Programmierung mit Java und dem Java-Editor.

## Grundidee

Die Schülerinnen und Schüler arbeiten zunächst modellorientiert über UML und die Oberfläche des Java-Editors. Der Übergang zum Java-Code erfolgt schrittweise: erst Modell und Objekte verstehen, dann den vom Java-Editor erzeugten Code nachvollziehen und später selbst Code ergänzen und schreiben.

## Struktur

- `downloads/mission-01/` bis `downloads/mission-13/` – Lösungen zum Nachvollziehen für den Java-Editor
- `downloads/shared/` – gemeinsam benötigte Dateien wie `SpaceWindow.java`
- `moodle/` – Hinweise zur aktuellen Moodle-Vollfassung
- `assets/icons/` – reservierter Projektordner; die bestehenden Space-Icons werden weiterhin zentral über `https://www.harzenetter.eu/moodle/src/` eingebunden

## Schülerdownloads

In den Downloadordnern liegen nur Dateien, die die Schülerinnen und Schüler wirklich benötigen:

- `.uml` – UML-Datei zum Öffnen im Java-Editor
- `.java` – die zugehörigen Java-Quelldateien
- `README.txt` – kurze Anleitung zum jeweiligen Download
- `.zip` – das jeweilige Schülerpaket zum einfachen Herunterladen

Die UML-Dateien sind im tatsächlich vom Java-Editor verwendeten Diagrammformat gespeichert und enthalten für jede sichtbare Klasse eigene Box-Informationen. `SpaceWindow` bleibt ab Mission 07 bewusst außerhalb des UML-Diagramms, weil die Klasse nur technische Infrastruktur bereitstellt.

**Nicht enthalten:** kompilierte `.class`-Dateien oder fertige Builds.

## Webserver

`moodle.harzenetter.eu` dient als zentraler Dateiserver für ausgelagerte Moodle-Materialien. Mission Space wird darunter in einem eigenen Unterordner bereitgestellt:

`https://moodle.harzenetter.eu/mission-space/`

Das Repository ist in Plesk/Netcup direkt als Remote-Git-Repository eingebunden. Der Branch `main` wird nach `mission-space` deployed.

Ein GitHub-Webhook informiert Plesk bei Änderungen. Dadurch läuft die Aktualisierung automatisch:

`Push auf main → Webhook → Plesk Pull → automatische Bereitstellung`

Der Bereitstellungspfad betrifft ausschließlich den Unterordner `mission-space`, sodass andere Inhalte unter `moodle.harzenetter.eu` davon getrennt bleiben.

## Moodle-Vollfassung

Die Moodle-Vollfassung wird als HTML-Fragment direkt in den Moodle-Editor eingefügt. Ihre Schülerdownloads verweisen auf `https://moodle.harzenetter.eu/mission-space/downloads/...`; die Space-Icons bleiben vorerst unter `https://www.harzenetter.eu/moodle/src/`.

Die alte v2-Webserver-ZIP und der frühere GitHub-Actions/SSH-Deploy wurden entfernt, damit nur noch der tatsächlich verwendete Plesk-Git-Weg dokumentiert ist.

## Wichtig

Zugangsdaten, private SSH-Schlüssel und andere Secrets gehören niemals in dieses Repository. Für das private GitHub-Repository erhält Plesk ausschließlich den zum Lesen benötigten Zugriff.
