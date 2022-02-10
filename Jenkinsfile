pipeline {
   agent any

   /**tools {
      // Install the Maven version configured as "M2" and add it to the path.
      maven "M2"
   } **/

   stages {
        stage('SCM Checkout'){
		 steps {
			git url: 'https://github.com/chittaranjanpanda/springbootmvc.git',branch: 'master'
		 }
		}
		
		stage(" Maven Clean Package"){
			steps {
				script {
					def mavenHome =  tool name: "M2"
					def mavenCMD = "${mavenHome}/bin/mvn"
					sh "${mavenCMD} clean package"
				}
			}
		}
		
		stage('Build Docker Image'){
			steps {
				sh 'docker build -t chittaranjanpanda/demoapp:$BUILD_TAG .'
			}
		}
		
		stage('Push Docker Image'){
			steps {
				withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'DOCKER_HUB_PASSWORD')]) {
					sh "docker login -u chittaranjanpanda -p ${DOCKER_HUB_PASSWORD}"
				}
				sh 'docker push chittaranjanpanda/demoapp:$BUILD_TAG'
				sh 'docker rmi chittaranjanpanda/demoapp:$BUILD_TAG'
			}
		}
		stage("Deploy To Kuberates Cluster"){
			steps {
				kubernetesDeploy(
					configs: 'workloads-jenkins.yml', 
					kubeconfigId: 'MK8S_CONFIG',
					enableConfigSubstitution: true
					)
				}
		}
      }
}
