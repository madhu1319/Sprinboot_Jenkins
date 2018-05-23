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
           sh 'curl -u tracuat:5gGMTDuW6RH9TUyTlp0X -T target/TestSp-0.0.1-SNAPSHOT.jar sftp://deheremap7122:22/opt/trac/TestSp-0.0.1-SNAPSHOT.jar'
             }
             }
    }
}
