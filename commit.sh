#!/bin/bash

for d in `ls -d */`
do
	cd $d
	git add -u
	git commit -m "$1"
	git push
	cd ..
done

git add -u
git commit -m $1
git push