DOCKER_REGISTRY ?= include
DOCKER_TAG ?= latest

all: buildx

buildx:
	docker build --no-cache -t ${DOCKER_REGISTRY}/satcom:${DOCKER_TAG} .

push:
	docker push ${DOCKER_REGISTRY}/satcom:${DOCKER_TAG}

run:
	docker run -it -p 8080:8080 -p 9990:9990 --name satcom include/satcom:latest