pipeline{

  agent any
  
  stages{
  
    stage('Compile Stage'){
    
      steps{
        withMaven(maven: 'm3'){
          sh 'mvn clean install -Dmaven.test.skip=true'
        }
      }
      
    }
      
    stage('Prune Image'){
    
      steps{
        sh "docker stop somi-test-jenkins"
        sh "docker image prune -f"
        echo "Old Image deleted from local"
      }
      
    }
    
    stage('Build Image'){
    
      steps{
        sh "docker build -t somi-jenkins-spring-docker:latest  -t somi-jenkins-spring-docker --pull --no-cache ."
        echo "Image build complete"
      }
      
    }
    
    stage('Push Image'){
    
      steps{
        sh "docker login -u madhu1319 -p may28th@MS"
        sh "docker tag somi-jenkins-spring-docker:latest madhu1319/somi-jenkins-spring-docker:latest"
        sh "docker push madhu1319/somi-jenkins-spring-docker:latest"
        echo "Image Push complete"
      }
      
    }
    
    stage('Deploy'){
    
      steps{
        sh "docker pull madhu1319/somi-jenkins-spring-docker:latest"
        sh "docker run -d --rm -p 8086:8086 --name somi-test-jenkins somi-jenkins-spring-docker"
        echo "Application Started on port : 8086"
      }
      
    }
    
      stage('Deploy In Another'){
    
      steps{
        sh "sshpass -p 'Madhu@123456' ssh -o ConnectTimeout=3000 -o StrictHostKeyChecking=no -o RequestTTY=no madhu1319@51.144.238.131 " docker ps""
        echo "Application Started in another"
      }
      
    }
  }
}