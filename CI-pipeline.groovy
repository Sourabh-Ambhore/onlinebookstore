pipeline {
    agent any
    stages {
        stage('git checkout') {
            steps {

                sh 'rm -rf *'
                git 'https://github.com/Pritam-Khergade/onlinebookstore.git'
            }
        }
        stage('maven build') {
            steps {
                sh ' mvn clean package ' 
            }
        }
        stage('aws s3 copy') {
            steps {
                sh''' aws s3 ls 
                aws s3 cp ./target/onlinebookstore.war s3://artifact-fdecb2/onlinebookstore${BUILD_NUMBER}.war
                '''
            }
        }
    }
}
