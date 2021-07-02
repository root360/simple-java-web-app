#!/bin/bash

SCRIPTDIR="$(dirname "$(readlink -f "$0")")"

mapfile -t jars < <(find "${SCRIPTDIR}" -name 'root360-*.jar')

if [[ "${#jars}" -eq 1 ]]; then
    jar="${jars[0]}"
else
    select jar in "${jars[@]}"; do
        break
    done
fi

java -jar "${jar}"
