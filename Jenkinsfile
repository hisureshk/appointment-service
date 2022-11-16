pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
               // git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                git branch: 'main', url: 'https://github.com/hisureshk/appointment-servvice.git'

                // Run Maven on a Unix agent.
                sh "mvn -DskipTests clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
               // git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                git branch: 'main', url: 'https://github.com/hisureshk/appointment-servvice.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Image Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true spring-boot:build-image"
            }
        }


        stage('Image Push') {
            steps {
                sh "docker tag appointment-service:0.0.1-SNAPSHOT hisureshk/appointment-service"
                sh "docker push hisureshk/appointment-service"
            }
        }

        stage('K8s Deploy') {
            steps {
                sh "kubectl config use-context minikube"
                sh "kubectl create -f k8s/service-deployment.yml"
            }
        }
    }
}
