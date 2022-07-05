mvn package -Dmaven.test.skip=true
docker build --tag biobank:latest .