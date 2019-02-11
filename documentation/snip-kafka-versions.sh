#!/usr/bin/env bash

# Generates documentation/book/ref-kafka-versions.adoc
# according to the values in kafka-versions

. $(dirname $0)/../multi-platform-support.sh

FILE=$1
cat <<EOF
// This assembly is included in the following assemblies:
//
// assembly-upgrading-kafka-versions.adoc
// Generated by documentation/supported-version.sh during the build
// DO NOT EDIT BY HAND
[options="header"]
|=================
|Kafka version |Interbroker protocol version |Log message format version| Zookeeper version
EOF
for x in $($GREP -E '^[^#]' "$FILE" | $SED -E 's/ +/|/g'); do
    
    for y in $(echo $x | $SED -E -e 's/[|][a-zA-Z0-9]+$'// -e 's/[|]/ /g' ); do
        if [ "$y" != 'default' ]; then
            echo -n "|$y "
        fi
    done
    echo "|3.4.13"
done
cat <<EOF
|=================
EOF