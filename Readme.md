# Note of Jar and Javac commands:

URL: <a href="https://docs.oracle.com/javase/tutorial/deployment/jar/index.html">Oracle JavaSE Jar Tutorial </a>
URL: <a href="https://stackoverflow.com/questions/5012125/javac-no-source-files-found">javac no source files found </a>
URL: <a href="https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html">Oracle Javac Documentation </a>
URL: <a href="https://docs.oracle.com/javase/7/docs/technotes/tools/windows/classpath.html">Oracle Class Path Documentation</a>
URL: <a href="https://stackoverflow.com/questions/44172563/bad-class-file-using-javac">bad class file using javac </a>
URL: <a href="http://command-line-wiki.github.io/compiling-programs/compiling-running-java-javac.html">CLI for Javac </a>
URL: <a href="https://stackoverflow.com/questions/12718723/javac-error-package-x-does-not-exist-at-import-x/12718762">Parenthese for jar in different OS </a>
URL: <a href="https://code.visualstudio.com/docs/java/java-project">Add jar in vscode </a>

<h4> To create jar </h4>

> jar cf 'example.jar' file folder ...
> jar cfm MANIFEST.txt 'example.jar' file folder ...
> jar cfv 'example.jar' ...

    options:
        c - create jar
        f - output to file
        m - use specified manifest
        v - verbose output to cmd (more details)

<h4> To view jar content </h4>

> jar tf 'example.jar'
> jar tfv 'example.jar'

    options:
        c - table of content
        f - cmd input (of jar name)
        v - verbose output to cmd (more details)

<h4> To extract jar content </h4>

> jar xf 'example.jar' file1 file2 ...
> jar xf 'example.jar'

    options:
        x - extract jar files (extract all and overwrite dir with same name if not specified)
        f - cmd input (of jar name)

<h4> To manually set entry point </h4>

> jar cfe 'example.jar' package.mainClassName package/mainClassName abc.class someFile .....

    options:
        c - table of content
        f - cmd input (of jar name)
        e - entry point (Class with main method. If the class (say 'Main.class') is
            under package say 'exec', the parameter should be: exec.Main)

<h4> MANIFEST name </h4>

> MANIFEST.MF

<h4> MANIFEST dir Structure </h4>

> META-INF/MANIFEST.MF

<h4> To create MANIFEST manually, and put it in jar </h4>

> create MANIFEST.txt
> jar cfm 'example.jar' 'MANIFEST.TXT' ....

<h4> MANIFEST file content: </h4>

> <key>: <value>
> Manifest-Version:
> Created-By:
> Main-Class: package\className
> Class-Path: folder/example.jar another.jar andAnother.jar ...

<h4> Command for creating display.jar </h4>

> jar cfm display.jar display\MANIFEST.txt display\Display.class display\lib

<h4> Command for compilng Display.java </h4>

> javac -cp .;lib\validate.jar display\Display.java

    options:
        -cp - same as -classpath, note that ".;" for windows os, and ".:" for ubuntu or linux os.

    can also set the environmnental variable - classPath as follows:
        set CLASSPATH='path to files'

    To view the variable:
        ECHO %CLASSPATH%

<h4> Command for creating validate.jar </h4>

> jar cfm validate.jar validate\MANIFEST.txt validate\*.class

<h4> For bad class problem </h4>

Say the structure of the directory in the jar is as follows:

-> example <dir>
---> main.java

The main.java must specify its package as follows, else bad calss problem may occur.

> package example;

<h4> Specifying .classpath file for VSCode </h4>

Create a .classpath file, and add following line in it:

> <classpathentry kind="lib" path="lib/example.jar"/>

<h4> Package Versioning Information </h4>

Package Versioning Information are provided in the MANIFEST.MF file as follows, none of these effect how the jar is imported. (I.e., import 'jar name'; )

> Name: display/text/
> Specification-Title: Classes for Text Display
> Specification-Version: 1.0
> Specification-Vendor: curtisnewbie org
> Implementation-Title: display.text
> Implementation-Version: build123
> Implementation-Vendor: curtiesnewbie org
