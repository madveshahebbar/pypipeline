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
        stage ('set-up') {
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
        stage('Unit Test') {
              steps
                {
                  sh '''
				   . calculator/bin/activate
				   cp /home/vagrant/calculator.py test_calculator.py .
				   flake8 calculator.py test_calculator.py --statistics
				 '''
			    }
		    }
		  stage('Code Coverage') {
		      steps
			    {  
			    sh '''
				   . calculator/bin/activate
				   pytest calculator.py test_calculator.py -v --cov
				'''
			    }
            }
	}
    }
