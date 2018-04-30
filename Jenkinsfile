pipeline {
    agent any
 
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'm3') {
                    sh 'mvn package'
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


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'm3') {
                    sh 'java -jar "C:\Program Files (x86)\Jenkins\workspace\First-Jenkins-Proj\target\TestSp-0.0.1-SNAPSHOT.jar"'
                }
            }
        }
    }
}