# Webserver-Struktur

`moodle.harzenetter.eu` wird als zentraler Dateiserver für ausgelagerte Moodle-Materialien verwendet.

Mission Space liegt in einem eigenen Unterordner:

`https://moodle.harzenetter.eu/mission-space/`

Für Moodle sind insbesondere diese Pfade relevant:

- `https://moodle.harzenetter.eu/mission-space/downloads/mission-01/...` bis `mission-13/...`
- `https://moodle.harzenetter.eu/mission-space/downloads/shared/SpaceWindow.java`

Die bereits vorhandenen Space-Icons werden vorerst weiterhin über

`https://www.harzenetter.eu/moodle/src/`

eingebunden. Sie können später ebenfalls auf die Moodle-Subdomain umgezogen werden, ohne die Schülerdownloads zu verändern.

Auf dem Netcup-Webhosting zeigt `MISSION_SPACE_DEPLOY_PATH` auf den Unterordner `mission-space` innerhalb des Dokumentenstamms von `moodle.harzenetter.eu`.
