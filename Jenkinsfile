pipeline {
    agent any

    environment {
        IMAGE_NAME = "beanbarrel_backend"
        IMAGE_TAG = "latest"
        CONTAINER_NAME = "beanbarrel_backend"
        APP_PORT = "9091"
        SPRING_PROFILE = ""
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                script {
                    // Determine the branch and set the appropriate Spring profile
                    if (env.GIT_BRANCH == 'origin/dev' || env.BRANCH_NAME == 'dev') {
                        SPRING_PROFILE = "dev"
                        echo "Using application-dev.properties"
                    } else if (env.GIT_BRANCH == 'origin/main' || env.BRANCH_NAME == 'main') {
                        SPRING_PROFILE = "prod"
                        echo "Using application-prod.properties"
                    } else {
                        SPRING_PROFILE = "dev"  // default fallback
                        echo "Defaulting to DEV profile"
                    }
                }
            }
        }

        stage('Clear Docker Cache') {
            steps {
                script {
                    echo "Clearing Docker cache (containers, images, networks, volumes, build cache)..."
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
                    sh "docker ps -q --filter name=${CONTAINER_NAME} | grep -q . && docker stop ${CONTAINER_NAME} || echo 'No container running'"
                    sh "docker ps -aq --filter name=${CONTAINER_NAME} | grep -q . && docker rm ${CONTAINER_NAME} || echo 'No container to remove'"
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    sh """
                        docker run -d \
                        -e SPRING_PROFILES_ACTIVE=${SPRING_PROFILE} \
                        -p ${APP_PORT}:${APP_PORT} \
                        --name ${CONTAINER_NAME} \
                        ${IMAGE_NAME}:${IMAGE_TAG}
                    """
                }
            }
        }
    }

    post {
        success {
            echo "Application deployed successfully with profile: ${SPRING_PROFILE}"
        }
        failure {
            echo "Pipeline failed."
        }
    }
}
