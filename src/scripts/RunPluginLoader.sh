#!/bin/bash
# Check if the user provided an argument
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 path/to/example.eclp"
    exit 1
fi

# Run the Java application
java -cp bin com.adaves1.Main "$1"
