#!/bin/bash

# Function to open GitHub
open_github() {
    local url="https://github.com/adaves1/EclispePlugin"
    echo "Opening $url in your web browser..."
    
    # Check the OS and open the URL accordingly
    if [[ "$OSTYPE" == "linux-gnu"* ]]; then
        xdg-open "$url"  # For Linux
    elif [[ "$OSTYPE" == "darwin"* ]]; then
        open "$url"      # For macOS
    elif [[ "$OSTYPE" == "cygwin" ]]; then
        start "$url"     # For Cygwin (Windows)
    elif [[ "$OSTYPE" == "msys" ]]; then
        start "$url"     # For Git Bash on Windows
    elif [[ "$OSTYPE" == "win32" ]]; then
        start "$url"     # For Windows
    else
        echo "Unsupported OS: $OSTYPE"
        exit 1
    fi
}

# Call the function to open GitHub
open_github
