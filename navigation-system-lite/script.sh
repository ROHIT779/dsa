#!/bin/bash
TARGET_PATH="./target/"
if [ -d "$TARGET_PATH" ]; then
  rm -r "$TARGET_PATH"
  mkdir "$TARGET_PATH"
else
  mkdir "$TARGET_PATH"
fi
find -name "*.java" > sources.txt
javac @sources.txt -d target
cd target
java com.demo.main.Navigation