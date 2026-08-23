# Mission Space – OOP in Java

Materialien für den Q1-Lernpfad **Mission Space** zur objektorientierten Programmierung mit Java und dem Java-Editor.

## Grundidee

Die Schülerinnen und Schüler arbeiten zunächst modellorientiert über UML und die Oberfläche des Java-Editors. Der Übergang zum Java-Code erfolgt schrittweise: erst Modell und Objekte verstehen, dann den vom Java-Editor erzeugten Code nachvollziehen und später selbst Code ergänzen und schreiben.

## Struktur

- `moodle/` – vollständige Moodle-Fassung Mission 01–13 für die Einbindung in den Kurs
- `assets/icons/` – Projektordner für Bilder und Icons; die bestehenden Space-Icons werden aktuell weiterhin über `https://www.harzenetter.eu/moodle/src/` eingebunden
- `downloads/mission-01/` bis `downloads/mission-13/` – Lösungen zum Nachvollziehen für den Java-Editor
- `downloads/shared/` – gemeinsam benötigte Dateien wie `SpaceWindow.java`
- `.github/workflows/` – Deployment auf den Webserver

## Schülerdownloads

In den Downloadordnern liegen nur Dateien, die die Schülerinnen und Schüler wirklich benötigen:

- `.uml` – UML-Datei zum Öffnen im Java-Editor
- `.java` – die zugehörigen Java-Quelldateien
- `README.txt` – kurze Anleitung zum jeweiligen Download
- `.zip` – das jeweilige Schülerpaket zum einfachen Herunterladen

**Nicht enthalten:** kompilierte `.class`-Dateien oder fertige Builds.

## Webserver

`moodle.harzenetter.eu` dient als zentraler Dateiserver für ausgelagerte Moodle-Materialien. Mission Space wird darunter in einem eigenen Unterordner bereitgestellt:

`https://moodle.harzenetter.eu/mission-space/`

Der Workflow `.github/workflows/deploy-netcup.yml` veröffentlicht die Downloadordner und entpackt zusätzlich die aktuelle Moodle-Vollfassung für den Webserver. Das Deployment läuft bewusst nicht automatisch bei jedem Commit, sondern nur manuell oder über ein Versionstag `v*`.

Der Workflow bricht ab, sobald eine `.class`-Datei im Veröffentlichungsstand gefunden wird. Außerdem akzeptiert er aus Sicherheitsgründen nur einen Zielpfad, der auf `.../mission-space` endet. Dadurch kann `rsync --delete` nicht versehentlich den gesamten Dokumentenstamm von `moodle.harzenetter.eu` leeren.

## Benötigte GitHub-Secrets

Für den ersten Deploy müssen im Repository beziehungsweise im Environment `production` folgende Secrets hinterlegt sein:

- `NETCUP_SSH_KEY`
- `NETCUP_SSH_HOST`
- `NETCUP_SSH_USER`
- `MISSION_SPACE_DEPLOY_PATH`

`MISSION_SPACE_DEPLOY_PATH` zeigt auf den Unterordner `mission-space` innerhalb des Dokumentenstamms von `moodle.harzenetter.eu`.

## Wichtig

Dieses Repository ist öffentlich. Zugangsdaten, SSH-Schlüssel und andere Secrets gehören niemals in das Repository, sondern ausschließlich in die GitHub-Secrets.
