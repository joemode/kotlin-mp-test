#!/bin/bash

echo "Usage: ./generateAgent.sh <agentname>"
PATH="~/DEV/android/kotlin-mp-test/src/commonMain/kotlin/api/"

AGENT="$1"

if [ -z "$1" ] 
then
    echo "No Agent name provided"
    exit
fi

echo $AGENT

