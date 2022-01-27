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
               
               bat "docker build -t priya2298/selenium-docker -t priya2298/selenium-docker:${BUILD_NUMBER} ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'priya2298', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        
			        bat "docker push priya2298/selenium-docker:latest"
			    }                           
                      
            }
        }
    }
}
