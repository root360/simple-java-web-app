#!/bin/bash

set -e

SCRIPTDIR="$(dirname "$(readlink -f "$0")")"

cat > /tmp/build.sh <<EOF
#!/bin/bash
export DEBIAN_FRONTEND="noninteractive"
apt update -qq -y
apt install -qq -y maven

cd /app
mvn clean package
chown -R "${UID}:${UID}" ./
EOF

chmod a+x /tmp/build.sh

rm -rf "${SCRIPTDIR}/target"

docker run -ti --rm -v "${SCRIPTDIR}:/app" -v "/tmp/build.sh:/build.sh" ubuntu:focal /build.sh

rm -f /tmp/build.sh
