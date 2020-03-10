#!/bin/bash

##################################
# Generate sc/ folder:

if [ -f "sc/" ]; then
	echo "Folder sc/ found, deleting it ..."
	rm -rf sc/
fi

echo "Generating sc/ ..."
OUTPUT=(java -jar ../sablecc.jar grammaireL.sablecc )
echo "Done."

##########################################
# Launch tests:
cd ../test

./evaluate.py

cd ../src
