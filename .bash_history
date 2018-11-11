#!/bin/bash
git fetch origin development
git reset --hard FETCH_HEAD
git pull
git init
git clone https://github.com/dmoore092/ISTE330FacultyResearchDB.git
git init
git branch -a
git branch
git status
