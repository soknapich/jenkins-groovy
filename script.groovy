// script.groovy

def buildImage() {
    echo "Building Docker Image..."
}

def pushImage() {
    echo "Pushing Image to DockerHub..."
}

def deployCompose() {
    echo "Deploying with Docker Compose..."
    sh """
        docker rm -f nginx 2>/dev/null || true && docker run -d --name nginx -p 80:80 nginx:latest
    """    
}

def sshToDomrey(){
    withCredentials([usernamePassword(credentialsId: 'my-ssh-server', 
                                     usernameVariable: 'SSH_USER', 
                                     passwordVariable: 'SSH_PASS')]) {
        sh '''
            sshpass -p "$SSH_PASS" ssh -o StrictHostKeyChecking=no $SSH_USER@domrey.com "hostname && whoami"
            sshpass -p "$SSH_PASS" scp -o StrictHostKeyChecking=no script.groovy $SSH_USER@domrey.com:/home/$SSH_USER/
        '''
    }
}

return this
