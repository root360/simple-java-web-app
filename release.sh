#!/bin/bash

set -e

SCRIPTDIR="$(dirname "$(readlink -f "$0")")"
version="${1:-1.0.0-SNAPSHOT}"

echo "Building package with version '${version}'"

cat > /tmp/build.sh <<EOF
#!/bin/bash
export DEBIAN_FRONTEND="noninteractive"
apt update -qq -y >/dev/null
apt install -qq -y maven >/dev/null

cd /app
sed -i "s/1.0.0-SNAPSHOT/${version}/" pom.xml
mvn clean package
git checkout pom.xml
chown -R "${UID}:${UID}" ./
EOF

chmod a+x /tmp/build.sh

rm -rf "${SCRIPTDIR}/target"

git tag --annotate "${version}" -s -m "release of ${version}"

docker run -ti --rm -v "${SCRIPTDIR}:/app" -v "/tmp/build.sh:/build.sh" ubuntu:focal /build.sh

rm -f /tmp/build.sh
