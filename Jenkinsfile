pipeline {
	parameters
         {
	  string(name: 'requirments.txt', description: '/home/ansadm/workspace/pypipeline')
	 }
	agent {
		node 'ansclt'
	}
	  stages {
	    stage('CheckOut SCM') {    
	       steps
	         { 
	          checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GIT', url: 'https://github.com/madveshahebbar/pypipeline.git']]])
	       	}
	    }
       }
	stage ('set-up')
		    {
		      steps
                {
                 sh '''
                    cd /home/ansadm
		    virtualenv calculator
		    . calculator/bin/activate
		   if [ "x${REQUIREMENTS_FILE}" != "x" ] && [ -f ${REQUIREMENTS_FILE} ]; then 
                   pip install -r ${REQUIREMENTS_FILE}; 
                   fi
                '''
                }
            }
    }
