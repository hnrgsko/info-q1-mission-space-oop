# Webserver-Struktur

`moodle.harzenetter.eu` wird als zentraler Dateiserver für ausgelagerte Moodle-Materialien verwendet.

Mission Space liegt in einem eigenen Unterordner:

`https://moodle.harzenetter.eu/mission-space/`

Für Moodle sind insbesondere diese Pfade relevant:

- `https://moodle.harzenetter.eu/mission-space/downloads/mission-01/...` bis `mission-13/...`
- `https://moodle.harzenetter.eu/mission-space/downloads/shared/SpaceWindow.java`

Die bereits vorhandenen Space-Icons werden vorerst weiterhin über

`https://www.harzenetter.eu/moodle/src/`

eingebunden.

## Deployment

Das GitHub-Repository ist direkt in Plesk als Remote-Repository eingebunden. Plesk deployed den Branch `main` in den Unterordner `mission-space` des Dokumentenstamms von `moodle.harzenetter.eu`.

Ein GitHub-Webhook stößt bei einem Push auf `main` automatisch den Pull und die Bereitstellung in Plesk an.

Der frühere GitHub-Actions/SSH-Workflow wird nicht mehr verwendet.
