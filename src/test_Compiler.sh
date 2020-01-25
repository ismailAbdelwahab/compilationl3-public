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
      	YELLOW "Recompiling the grammar to generate sc/:"
       	java -jar ../sablecc.jar grammaireL.sablecc
	GREEN "\tFolder sc/ created."
fi

################################
#Compile the compiler
YELLOW " === Compiling Compiler.java ==="
javac Compiler.java
GREEN "     Compilation done.\n"

################################
# Test all files in ../test/input
TEST_FOLDER="../test/input/*.l" 
BLUE "Starting to test with all file in: [${NC}${TEST_FOLDER}${BLUE}]"

# Array of files incorrect syntactically
declare -a files_with_errors=()

for file in ${TEST_FOLDER}
do
	filename=$(basename ${file})
	YELLOW "Testing file: ${filename}"	
	OUTPUT="$(java Compiler ${file})"
	if [ "${OUTPUT}" == "[SC]" ]
	then
		GREEN "\tProgram syntactically correct."
	else
		files_with_errors+=("${filename}")
		echo -e "${RED}\tError detected:${NC} ${OUTPUT}"
	fi
	done

echo ""

# Print final message: errors found or successful execution.
if [ ${#files_with_errors[@]} -eq 0 ]
then
	GREEN "\tAll files were tested."
	GREEN "  No error found. Exiting successfuly.\n"
else
	RED "\tSome errors were found."
	RED "Here is the list of files with errors:"
	for filename in "${files_with_errors[@]}"
	do
		printf " ${filename} "
	done
	echo ""
fi
