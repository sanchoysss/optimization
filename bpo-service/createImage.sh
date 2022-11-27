mvn clean install
now=$(date +"%Y%m%d_%H%M%S")
docker build -t sanchoys/optimization-bpo:"$now" .
docker push sanchoys/optimization-bpo:"$now"