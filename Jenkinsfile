pipeline{

  agentanystages{
  
    stage('Compile Stage'){
    
      steps{
        withMaven(maven: 'm3'){
          sh 'mvn clean install'
        }
      }
      
    }
    
    stage('Testing Stage'){
    
      steps{
        withMaven(maven: 'm3'){
          sh 'mvn test'
        }
      }
      
    }
    
    stage('Build Image'){
    
      steps{
        sh "docker build -t somi-jenkins-spring-docker:latest  -t somi-jenkins-spring-docker --pull --no-cache ."
        echo "Image build complete"
      }
      
    }
    
    stage('Deploy'){
    
      steps{
        sh "docker run -d --rm -p 8086:8086 --name somi-test-jenkins somi-jenkins-spring-docker"
        echo "Deployment Completed"
      }
      
    }
  }
}