#!/bin/sh
java -cp "${project.build.finalName}.jar:lib/*" ro.jtonic.sterge.springbootassembly.SpringBootAssemblyApplication
