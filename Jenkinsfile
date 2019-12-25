def CONTAINER_NAME="somi-test-jenkins"
def IMAGE_NAME="somi-jenkins-spring-docker"
def CONTAINER_TAG="latest"
def USERNAME="madhu1319"
def HTTP_PORT="8086"
def PASSWORD="may28th@MS"

def remote = [:]
  remote.name = 'AuzreVM'
  remote.host = '51.144.238.131'
  remote.user = 'madhu1319'
  remote.password = 'Madhu@123456'
  remote.allowAnyHosts = true

node {

    stage('Initialize'){
        def dockerHome = tool 'docker'
        def mavenHome  = tool 'm3'
        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    }

    stage('Checkout') {
        checkout scm
    }

    stage('Build Code'){
        sh "mvn clean install -Dmaven.test.skip=true"
    }

    stage("Image Prune"){
        imagePrune(CONTAINER_NAME)
    }

    stage('Image Build'){
        imageBuild(IMAGE_NAME, CONTAINER_TAG)
    }

    stage('Push to Docker Registry'){
            pushToImage(IMAGE_NAME, CONTAINER_TAG, USERNAME, PASSWORD)
 
    }

    stage('Run App in Same VM'){
        runApp(IMAGE_NAME,CONTAINER_NAME, CONTAINER_TAG, USERNAME, HTTP_PORT)
    }
    
    stage('Run App in Other VM'){
    sshCommand remote: remote, sudo: true, command: "ls -lrt"
    sshCommand remote: remote, sudo: true, command: "docker stop $CONTAINER_NAME"
    sshCommand remote: remote, sudo: true, command: "docker image prune -f"
    sshCommand remote: remote, sudo: true, command: "docker login -u $USERNAME -p $PASSWORD"
    sshCommand remote: remote, sudo: true, command: "docker pull $USERNAME/$IMAGE_NAME"
    sshCommand remote: remote, sudo: true, command: "docker run -d --rm -p $HTTP_PORT:$HTTP_PORT --name $CONTAINER_NAME $USERNAME/$IMAGE_NAME:$CONTAINER_TAG"
    }

}

def imagePrune(containerName){
    try {
    	sh "docker stop $containerName"
        sh "docker image prune -f"
    } catch(error){}
}

def imageBuild(containerName, tag){
    sh "docker build -t $containerName:$tag  -t $containerName --pull --no-cache ."
    echo "Image build complete"
}

def pushToImage(containerName, tag, dockerUser, dockerPassword){
    sh "docker login -u $dockerUser -p $dockerPassword"
    sh "docker tag $containerName:$tag $dockerUser/$containerName:$tag"
    sh "docker push $dockerUser/$containerName:$tag"
    echo "Image push complete"
}

def runApp(imageName,containerName, tag, dockerHubUser, httpPort){
    sh "docker pull $dockerHubUser/$imageName"
    sh "docker run -d --rm -p $httpPort:$httpPort --name $containerName $dockerHubUser/$imageName:$tag"
    echo "Application started on port: ${httpPort} (http)"
}