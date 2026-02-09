#!/usr/bin/env bash
set -o nounset
set -o errexit

SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)
cd "$SCRIPT_DIR"

GRADLE_USER_HOME=${GRADLE_USER_HOME:-$HOME/.gradle}
WRAPPER_JAR="$SCRIPT_DIR/gradle/wrapper/gradle-wrapper.jar"
WRAPPER_PROPERTIES="$SCRIPT_DIR/gradle/wrapper/gradle-wrapper.properties"

# Download gradle-wrapper.jar if it doesn't exist
if [ ! -f "$WRAPPER_JAR" ]; then
    mkdir -p "$(dirname "$WRAPPER_JAR")"
    echo "Downloading gradle wrapper..."
    curl -L "https://raw.githubusercontent.com/gradle/gradle/master/gradle/wrapper/gradle-wrapper.jar" -o "$WRAPPER_JAR" 2>/dev/null || {
        # Fallback: use gradle from system
        if command -v gradle &> /dev/null; then
            exec gradle "$@"
        else
            echo "Error: gradle-wrapper.jar not found and gradle not installed"
            exit 1
        fi
    }
fi

exec java -cp "$WRAPPER_JAR" org.gradle.wrapper.GradleWrapperMain "$@"
