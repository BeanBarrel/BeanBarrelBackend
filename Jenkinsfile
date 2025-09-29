pipeline {
    agent any

    environment {
        IMAGE_NAME = "beanbarrel_backend"
        IMAGE_TAG = "latest"
        CONTAINER_NAME = "beanbarrel_backend"
        APP_PORT = "9091"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        // ✅ New Stage: Clear Docker Cache
        stage('Clear Docker Cache') {
            steps {
                script {
                    echo "Clearing Docker cache (containers, images, networks, volumes, build cache)..."
                    // Force remove everything unused
                    sh "docker system prune -af --volumes || echo 'Docker prune failed or nothing to prune'"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build --no-cache -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                }
            }
        }

        stage('Stop & Remove Existing Container') {
            steps {
                script {
                    // Stop container if running
                    sh "docker ps -q --filter name=${CONTAINER_NAME} | grep -q . && docker stop ${CONTAINER_NAME} || echo 'No container running'"
                    // Remove container if exists
                    sh "docker ps -aq --filter name=${CONTAINER_NAME} | grep -q . && docker rm ${CONTAINER_NAME} || echo 'No container to remove'"
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                sh "docker run -d -p ${APP_PORT}:${APP_PORT} --name ${CONTAINER_NAME} ${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }
    }

    post {
        success {
            echo "Application deployed successfully!"
        }
        failure {
            echo "Pipeline failed."
        }
    }
}
