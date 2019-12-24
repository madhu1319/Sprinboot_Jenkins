pipeline {
    agent any
 
    stages {
        stage ('Compile Stage') {

            steps {
                echo "Compile Step"
            }
        }

        stage ('Testing Stage') {

            steps {
                echo "Testing Step"
            }
        }


        stage ('Deploy') {
             steps {
           sh "docker ps"
           sh "docker --version"
             }
             }
    }
}
