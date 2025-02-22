pipeline {
    agent any

    triggers { 
        githubPush()  
    }

    environment {
        DOCKER_IMAGE_NAME = 'calculator'
        DOCKER_HUB_REPO = 'tathagata125/calculator'
        GITHUB_REPO_URL = 'https://github.com/tathagata125/SoftwareMini.git'
        
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Clone GitHub repo
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image using Dockerfile
                    //docker.build("${DOCKER_IMAGE_NAME}", '.')
                      sh "docker build -t ${DOCKER_IMAGE_NAME} ."
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script{
                    withCredentials([string(credentialsId: 'DockerHubCred', variable: 'DOCKER_HUB_PASSWORD')]) {
                    sh "echo '${DOCKER_HUB_PASSWORD}' | docker login -u 'tathagata125' --password-stdin"
                    sh 'docker tag calculator tathagata125/calculator:latest'
                    sh 'docker push tathagata125/calculator'
                    }
                 }
            }
        }
       stage('Run Ansible Playbook') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'sudo-password', variable: 'SUDO_PASSWORD')]) {
                        // Write the inventory file dynamically
                        writeFile file: 'inventory', text: """
                            localhost ansible_connection=ssh ansible_user=tathagata ansible_ssh_pass='${SUDO_PASSWORD}'
                        """

                        // Run the Ansible playbook
                        ansiblePlaybook(
                            playbook: 'deploy.yml',
                            inventory: 'inventory'
                        )
                    }
                }
            }
        }

    }
}




