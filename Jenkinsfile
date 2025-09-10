// Load the external script.groovy file
def gv

pipeline {
    agent any

    environment {
        ImageRegistry = 'oluwaseuna'
        EC2_IP = 'domrey.com'
        DockerComposeFile = 'docker-compose.yml'
        DotEnvFile = '.env'
    }

    stages {
        stage ("init"){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        
        stage("buildImage") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }

        stage("pushImage") {
            steps {
                script {
                    gv.pushImage()
                }
            }
        }

        stage("deployCompose") {
            steps {
                script {
                    gv.deployCompose()
                }
            }
        }

        stage("TestSShToDomrey") {
            steps {
                script {
                    gv.sshToDomrey()
                }
            }
        }
        
    }
}
