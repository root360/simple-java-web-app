#!/bin/bash

cat > /tmp/build.sh <<EOF
#!/bin/bash
export DEBIAN_FRONTEND="noninteractive"
apt update -qq -y
apt install -qq -y maven

cd /app
rm -rf target
mvn clean package
chown -R "${UID}:${UID}" ./
EOF

chmod a+x /tmp/build.sh

docker run -ti --rm -v "${PWD}:/app" -v "/tmp/build.sh:/build.sh" ubuntu:focal /build.sh

rm -f /tmp/build.sh
