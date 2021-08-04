#!/bin/bash
echo -n "Please enter characters count:"
read count

mkdir "dir1"
touch "dir1/big_ones.txt"
mkdir "dir2"
touch "dir2/small_ones.txt"
echo "Directories created"

filenames=$(find ./* -name "*.java" | xargs basename)
echo "$filenames"
for eachfile in $filenames
do
   if [[ "eachfile" -gt count ]]; then
   	echo "eachfile" > dir1/big_ones.txt
   else
   	echo "eachfile" > dir2/small_ones.txt
   fi

done
