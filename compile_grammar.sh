#!/bin/bash

GREEN=`tput bold && tput setaf 2`
NC=`tput sgr0`

function GREEN(){
        echo -e ${GREEN}${1}${NC}
}

GREEN "\t=== Compiling the grammar ===\n"

java -jar sablecc.jar src/grammaireL.sablecc

echo -e ""
