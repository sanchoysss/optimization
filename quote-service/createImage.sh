mvn clean install
now=$(date +"%Y%m%d_%H%M%S")
docker build -t sanchoys/optimization-quote:"$now" .
docker push sanchoys/optimization-quote:"$now"