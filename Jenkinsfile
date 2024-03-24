pipeline{
    agent any
    tools{
        maven "maven"
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
        stage("Deploy to tomcat"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcatcreds', path: '', url: 'http://localhost:9000/')], contextPath: 'classthree', war: '**/*.war'
            }
        }
    }
}
