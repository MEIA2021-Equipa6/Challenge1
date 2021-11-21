DOCKER_REGISTRY ?= include
DOCKER_TAG ?= latest
PROJECT_NAME ?= satcom

all: buildx

buildx:
	docker build --no-cache -t ${DOCKER_REGISTRY}/${PROJECT_NAME}:${DOCKER_TAG} .

push:
	docker push ${DOCKER_REGISTRY}/${PROJECT_NAME}:${DOCKER_TAG}

run:
	docker run -it -p 8080:8080 -p 9990:9990 --name ${PROJECT_NAME} ${DOCKER_REGISTRY}/${PROJECT_NAME}:${DOCKER_TAG}