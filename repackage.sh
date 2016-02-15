#!/bin/sh

###################################################################################
# Shell script for repackaging subsonic.  See http://subsonic.org.
#
# Author: Sindre Mehus
###################################################################################
BUILD="DKE-Custom-1"

cd "${0%/*}"
SUBSONIC_ROOT=`pwd`

#Build Acegi-Security
rm -rf "$SUBSONIC_ROOT/src/acegi-security/target"
cd "$SUBSONIC_ROOT/src/acegi-security"
mvn package

#Build Subsonic
rm -rf $SUBSONIC_ROOT/src/subsonic/*/target
cd "$SUBSONIC_ROOT/src/subsonic"
mvn package

#Extract Subsonic to replace Acegi-Security
mkdir "$SUBSONIC_ROOT/subsonic_tmp"
cd "$SUBSONIC_ROOT/subsonic_tmp"
jar -xf "$SUBSONIC_ROOT/src/subsonic/subsonic-main/target/subsonic.war"

ACEGI_JAR=`ls "$SUBSONIC_ROOT/src/acegi-security/target" | grep -E acegi-security-[0-9]+.[0-9]+.[0-9]+.jar`

ACEGI_NEEDED=`ls "$SUBSONIC_ROOT/src/subsonic/subsonic-main/target/subsonic/WEB-INF/lib" | grep "acegi-security"`

if [ "$ACEGI_NEEDED" = "$ACEGI_JAR" ]; then

  cp "$SUBSONIC_ROOT/src/acegi-security/target/$ACEGI_JAR" "$SUBSONIC_ROOT/subsonic_tmp/WEB-INF/lib/"
  echo $BUILD > "$SUBSONIC_ROOT/subsonic_tmp/WEB-INF/classes/build_number.txt"

  rm "$SUBSONIC_ROOT/subsonic.war"
  jar -cf "$SUBSONIC_ROOT/subsonic.war" *

else

  echo "ERROR: acegi-security jars do not match"

fi

cd $SUBSONIC_ROOT
rm -rf "$SUBSONIC_ROOT/subsonic_tmp"

echo "---------------------------------"
echo "Subsonic.war repackaging complete"
echo "---------------------------------"
