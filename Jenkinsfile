pipeline {
    
    agent any
    stages {
        stage('Build Jar') {
            steps {
               
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
               
               bat "docker build -t myflixdocker/selenium-docker -t myflixdocker/selenium-docker:${BUILD_NUMBER} ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        bat "docker login --username=admin --password=admin"
			        bat "docker push myflixdocker/selenium-docker:latest"
			    }                           
                      
            }
        }
    }
}
