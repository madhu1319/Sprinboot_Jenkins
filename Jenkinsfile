pipeline {
    agent any
 
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'm3') {
                    sh 'mvn clean install'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'm3') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deploy') {
             steps {
           sh "docker build -t somi-jenkins-spring-docker:latest  -t somi-jenkins-spring-docker --pull --no-cache ."
    		echo "Image build complete"
             }
             }
    }
}
