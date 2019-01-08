pipeline {
    agent any {
	 stages {
	    stage('CheckOut') {    
	       steps
	         { 
	          checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GIT', url: 'https://github.com/madveshahebbar/pypipeline.git']]])
	       	}
	    }
       }
    }
}
