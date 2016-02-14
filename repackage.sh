#!/bin/sh

###################################################################################
# Shell script for repackaging subsonic.  See http://subsonic.org.
#
# Author: Sindre Mehus
###################################################################################
BUILD="DKE-Custom-1"

#Acegi Security Jar file name
ACEGI_JAR="acegi-security-1.0.5.jar"
#--This can be found in the subsonic war file in WEB-INF/lib
#  If the version does not match what is below, the newer jar file's source code will
#  need to be downloaded and modified.  Refer to the following commit as an example.
#  https://github.com/DKE-ST/subsonic/commit/7f7114bcfe1b8d5d873aa7cd52310f1b5936c6d0

cd "${0%/*}"
SUBSONIC_ROOT=`pwd`

#Build Acegi-Security
cd "$SUBSONIC_ROOT/src/acegi-security"
mvn package

#Build Subsonic
cd "$SUBSONIC_ROOT/src/subsonic"
mvn package

#Extract Subsonic to replace Acegi-Security
mkdir "$SUBSONIC_ROOT/subsonic_tmp"
cd "$SUBSONIC_ROOT/subsonic_tmp"
jar -xf "$SUBSONIC_ROOT/src/subsonic/subsonic-main/target/subsonic.war"

cp "$SUBSONIC_ROOT/src/acegi-security/target/$ACEGI_JAR" "$SUBSONIC_ROOT/subsonic_tmp/WEB-INF/lib/"
echo $BUILD > "$SUBSONIC_ROOT/subsonic_tmp/WEB-INF/classes/build_number.txt"

jar -cf "$SUBSONIC_ROOT/subsonic.war" *

cd $SUBSONIC_ROOT
rm -rf "$SUBSONIC_ROOT/subsonic_tmp"

echo "---------------------------------"
echo "Subsonic.war repackaging complete"
echo "---------------------------------"
