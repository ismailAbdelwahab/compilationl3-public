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

################################
#Check if sc/ folder exists

if [ ! -d "sc" ] 
then
	RED "\tERROR : Folder sc/ not found."
      	YELLOW "Please recompile the grammar to generate sc/:"
	BLUE "Commands to execute:"
       	BLUE "\t\$cd .."
	BLUE "\t\$./compile_grammar.sh"	
	exit -1
fi

################################
#Compile the compiler
YELLOW " === Compiling Compiler.java ==="
javac Compiler.java
GREEN "     Compilation done.\n"

################################
# Test all files in ../test/input

for filename in ../test/input/*.l; do
	YELLOW "Testing file: ${filename}"
	java Compiler ${filename}
	echo ""
done

GREEN " All file were tested. exit successful."
