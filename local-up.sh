#!/bin/bash

# dar permisos de ejecucion con chmod 755 local-up.sh
# Cambia al directorio donde se encuentra este script
# Para ejecutar debemos hacerlo de la siguiente manera: ./local-up.sh
cd "$(dirname "$0")"

# Ejecuta el comando Gradle
gradle bootRun --args="--spring.profiles.active=local"