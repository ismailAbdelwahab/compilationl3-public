#!/bin/bash

RED=`tput bold && tput setaf 1`
GREEN=`tput bold && tput setaf 2`
YELLOW=`tput bold && tput setaf 3`
BLUE=`tput bold && tput setaf 4`
NC=`tput sgr0`

function RED(){
        echo -e ${RED}${1}${NC} 
}
function GREEN(){
        echo -e ${GREEN}${1}${NC}
}
function YELLOW(){
        echo -e ${YELLOW}${1}${NC}
}
function BLUE(){
        echo -e ${BLUE}${1}${NC}
}

echo -e "File tested is -> sub2.l\n"
java Compiler ../test/input/sub2.l
