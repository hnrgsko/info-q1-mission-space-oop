# Mission Space – OOP in Java

Materialien für den Q1-Lernpfad **Mission Space** zur objektorientierten Programmierung mit Java und dem Java-Editor.

## Grundidee

Die Schülerinnen und Schüler arbeiten zunächst modellorientiert über UML und die Oberfläche des Java-Editors. Der Übergang zum Java-Code erfolgt schrittweise: erst Modell und Objekte verstehen, dann den vom Java-Editor erzeugten Code nachvollziehen und später selbst Code ergänzen und schreiben.

## Struktur

- `moodle/` – HTML-Quelltext für den Moodle-Lernpfad Mission 01–13
- `assets/icons/` – Bilder und Icons für die Moodle-Seiten
- `downloads/mission-01/` bis `downloads/mission-13/` – Lösungen zum Nachvollziehen für den Java-Editor
- `.github/workflows/` – später: Deployment auf den Webserver

## Schülerdownloads

In den Downloadordnern liegen nur Dateien, die die Schülerinnen und Schüler wirklich benötigen:

- `.uml` – UML-Datei zum Öffnen im Java-Editor
- `.java` – die zugehörigen Java-Quelldateien
- `README.txt` – kurze Anleitung zum jeweiligen Download

**Nicht enthalten:** kompilierte `.class`-Dateien oder fertige Builds.

## Webserver

Die Dateien sollen später zentral unter `https://www.harzenetter.eu/moodle/mission-space/` bereitgestellt und aus Moodle direkt verlinkt werden. Das Deployment wird erst eingerichtet, wenn die Repository-Struktur und die Materialien geprüft sind.

## Wichtig

Dieses Repository ist öffentlich. Zugangsdaten, SSH-Schlüssel und andere Secrets gehören niemals in das Repository, sondern ausschließlich in die GitHub-Secrets des Repositories.
