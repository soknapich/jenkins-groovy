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

return this
