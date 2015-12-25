mkdir -p bin

find ./src -name *.java > bin/sources_list.txt
javac -source 1.7 -target 1.7 -d ./bin -classpath "${CLASSPATH}" @bin/sources_list.txt

jar cmf manifest.mf mc-hc.jar *
