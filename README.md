## Running the project

From the repository root directory, type
```
cd wket
rake
```

Note: you must have the Ruby gem 'js_base' installed.
See `https://github.com/jpsember/js_base`

## How project was created

From the repository's root directory, I typed:
```
mvn archetype:generate \
   -DarchetypeGroupId=org.apache.wicket \
   -DarchetypeArtifactId=wicket-archetype-quickstart \
   -DarchetypeVersion=7.1.0 \
   -DgroupId=com.js \
   -DartifactId=wket \
   -DarchetypeRepository=https://repository.apache.org/ \
   -DinteractiveMode=false
```
