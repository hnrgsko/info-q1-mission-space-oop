# Deployment-Workflows

`deploy-netcup.yml` veröffentlicht Mission Space auf dem Netcup-Webserver.

Der Workflow wird bewusst nur manuell über **Run workflow** oder über ein Versionstag `v*` gestartet. Vor dem Upload wird geprüft, dass keine kompilierten `.class`-Dateien enthalten sind.

Benötigte Secrets:

- `NETCUP_SSH_KEY`
- `NETCUP_SSH_HOST`
- `NETCUP_SSH_USER`
- `MISSION_SPACE_DEPLOY_PATH`

`MISSION_SPACE_DEPLOY_PATH` muss auf das Webserver-Verzeichnis für `https://www.harzenetter.eu/moodle/mission-space/` zeigen und auf `/moodle/mission-space` enden.

Zugangsdaten und SSH-Schlüssel werden niemals im Repository gespeichert.
