/*
pipeline{
    agent any
    tools{
        maven "maven"
    }
    stages{

        stage("SCM Checkout"){
            steps{
                checkout scmGit(branches: [[name: '*//*
main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Rajasekhar2011/classtwofinal.git']])
            }
        }
        stage("Build"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }
        stage("Deploy to tomcat"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcatcreds', path: '', url: 'http://localhost:9000/')], contextPath: 'classthree', war: '** /*
*/
/*.war'
            }
        }
    }
}
 */
pipeline{
    agent any
    tools{
        maven "maven"
    }
    environment{
        APP_NAME = "springboot-docker-app-pipeline"
        RELEASE = "1.0.0"
        DOCKER_USER = "rrajasekharreddy"
        IMAGE_NAME = "${DOCKER_USER}"+"/"+"${APP_NAME}"
        IMAGE_TAG = "${RELEASE}-${BUILD_NUMBER}"
    }
    stages{

        stage("SCM Checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Rajasekhar2011/classtwofinal.git']])
            }
        }
        stage("Build"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }
        stage("Create an image"){
            steps{
                script{
                    bat "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                }
            }
        }

        stage("Push to Docker Hub"){
            steps{
                withCredentials([string(credentialsId: 'dockerpwd', variable: 'dockerpwd')]) {
                    bat "docker login -u rrajasekharreddy -p ${dockerpwd}"
                    bat "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
        }

    }
}
