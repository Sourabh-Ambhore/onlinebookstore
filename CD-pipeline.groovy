pipeline {
    agent any 
    stages {
        stage('git checkout') {
            steps {
                sh 'rm -rf *'
                sh 'git clone https://github.com/Sourabh-Ambhore/onlinebookstore.git'
                
            }
        }
        stage('Deploy') {
            steps {
                sh''' ls -al
                cd onlinebookstore
                terraform init 
                terraform plan 
                terraform apply --auto-approve
                '''
            }
        }
    }
}
