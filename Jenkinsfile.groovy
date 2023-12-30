pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    parameters {
        choice choices: ['master', 'ui_tests', 'ci-cd'], description: 'Select branch', name: 'BRANCH'
        text defaultValue: 'This is the changelog.', description: 'Enter the changelog.', name: 'CHANGELOG'
    }
    triggers {
        cron('H */4 * * 1-5')
    }
    stages {
        stage('Checkout'){
            steps{
                // Get some code from a GitHub repository
                git 'https://github.com/shtonoyan/TA-Advanced.git'
            }
        }
        stage('Clean') {
            steps {
                echo 'Cleaning workspace...'
                bat 'mvn clean'

            }

        }
        stage('Run Automation Tests'){
            steps {
                withCredentials([usernamePassword(credentialsId: 'TestUser', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                    echo "username: $USERNAME"
                    bat 'mvn -Dusername=%USERNAME% -Dpassword=%PASSWORD% test'
                }
            }
        }
        stage('Publish Allure Report'){
            steps{
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }

    }
}



