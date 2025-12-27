@ECHO OFF
SETLOCAL
SET DIR=%~dp0
IF NOT "%JAVA_HOME%"=="" SET JAVA_EXE=%JAVA_HOME%\bin\java.exe
IF "%JAVA_EXE%"=="" SET JAVA_EXE=java
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% -classpath "%DIR%\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
