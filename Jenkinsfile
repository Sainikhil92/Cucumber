pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                script {
                   env.PATH = "C:\\Program Files\\Java\\jdk-17\\bin;C:\\Users\\Nikhil_Abburi\\Downloads\\apache-maven-3.9.6\\bin;C:\\Windows\\System32"
                   git branch: 'main', credentialsId: '3ba14946-bc66-44d1-af43-390e21e0910a', url: 'https://github.com/Sainikhil92/Cucumber.git'
                }
            }
        }

        stage('build') {
            steps {
                bat 'C:\\github\\Cucumber\\bat.bat'
            }
        }

        stage('Post Actions') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
                cucumber buildStatus: 'STABLE', jsonReportDirectory: 'C:\\github\\Cucumber\\target\\cucumber-json-reports', fileIncludePattern: '**//*.json'
            }
        }
    }
}
