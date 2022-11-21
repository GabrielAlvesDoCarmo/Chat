pipeline {

    agent {
        docker {
            image 'androidsdk/android-30'
        }
    }
    /* agent { label 'mac' } */

    environment {
        branch = 'master'
        url = 'https://github.com/GabrielAlvesDoCarmo/Chat.git'
    }

    stages {

        stage('Checkout git') {
            steps {
                git branch: branch, credentialsId: 'chat', url: url
            }
        }

        /* stage('Lint') {
            steps {
                sh "./gradlew lint"
            }
        }

        stage('Test') {
            steps {
                sh "./gradlew test --stacktrace"
            }
        } */

        // Manage Jenkins > Credentials > Add > Secret file or Secret Text
        stage('Credentials') {
            steps {
                withCredentials([file(credentialsId: 'APP_CHAT_ID_FIREBASE', variable: 'APP_CHAT_ID_FIREBASE')]) {
                    sh "export ${APP_CHAT_ID_FIREBASE}"
                }
                withCredentials([file(credentialsId: 'KEYSTORE', variable: 'KEYSTORE')]) {
                    sh "cp '${KEYSTORE}' app/chat_keystore.jks"
                    sh "cat app/chat_keystore.jks"
                }
                withCredentials([file(credentialsId: 'FIREBASE', variable: 'FIREBASE')]) {
                    sh "cp '${FIREBASE}' app/firebase_service_distribuition.json"
                    sh "cat app/firebase_service_distribuition.json"
                }
                withCredentials([file(credentialsId: 'SERVICE_ACCOUNT', variable: 'SERVICE_ACCOUNT')]) {
                    sh "cp '${SERVICE_ACCOUNT}' app/service_account_play_console.json"
                    sh "cat app/service_account_play_console.json"
                }                
            }
        }

        stage('Build') {
            steps {
                sh "./gradlew clean assembleRelease"
            }
        }

        stage('Publish') {
            parallel {
                stage('Firebase Distribution') {
                    steps {
                        sh "./gradlew assembleRelease appDistributionUploadRelease"
                    }
                }

                stage('Internal Test PlayConsole') {
                    steps {
                        sh "./gradlew assembleRelease publishBundle"
                    }
                }
            }
        }
    }

    post {
       always {
           sh "rm app/chat_keystore.jks"
           sh "rm app/firebase_service_distribuition.json"
           sh "rm app/service_account_play_console.json"
       }
    }

}
