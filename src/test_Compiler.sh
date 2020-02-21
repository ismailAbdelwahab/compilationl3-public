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
# Delete and generate again sc/ directory

sc_dir="sc/"
if [ -d ${sc_dir} ] 
then
      	YELLOW " === Deleting ${sc_dir} ==="
	rm -rf ${sc_dir}
	GREEN "\t${sc_dir} deleted.\n"
fi

YELLOW " === Generating ${sc_dir} ===" 
OUTPUT=$(java -jar ../sablecc.jar grammaireL.sablecc)

if [ $? -ne 0 ] # if compilation of grammar FAILED
then
	echo ${OUTPUT}
	RED "\tError detected in the grammar."
	YELLOW " Please check the output of the compilation above.\n"
	exit -1
else
	GREEN "\tGrammar compiled.\n\tDirectory ${sc_dir} created.\n"
fi


################################
# Compile the compiler
YELLOW " === Compiling Compiler.java ==="
OUTPUT=$(javac Compiler.java)

if [ "${OUTPUT}" != "" ] # if compilation of Compiler.java FAILED
then
	echo ${OUTPUT}
	RED "\t Error detected when compiling Compiler.java :"
	YELLOW " Please check the output of the compilation above.\n"
	exit -1
else
	GREEN "\tCompiler.java compiled.\n"
fi

################################
# Test all files in ../test/input
TEST_FILES="../test/input/*.l"
YELLOW " === Launching tests ==="
BLUE "Starting to test with all file in: [${NC}${TEST_FILES}${BLUE}]"

declare -a files_with_errors=() # Array of files incorrect syntactically

for file in ${TEST_FILES}
do
	filename=$(basename ${file})
	YELLOW "Testing file: < ${NC}${filename}${YELLOW} >"	
	OUTPUT="$(java Compiler ${file})"
	if [ "${OUTPUT}" == "[SC]\n[SA]\n" ]
	then
		GREEN "\t[SC] -> Program syntactically correct."
		GREEN "\t[SA] -> Abstract syntax verified."
	else
		files_with_errors+=("${filename}")
		echo -e "${RED}\tError detected:\n${NC}${OUTPUT}"
	fi
	done

echo ""

############################################################
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
