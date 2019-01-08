pipeline {
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
	               sudo pip install flake8 pytest pytest-cov 
                  '''
               }
           }
        stage('Unit Test') {
              steps
                {
                  sh '''
		        cd /home/ansadm/workspace/pypipeline/
			. calculator/bin/activate
                        flake8 calculator.py test_calculator.py --statistics
		     '''
			 }
		    }
		  stage('Code Coverage') {
		      steps
			    {  
			    sh '''
				 pytest calculator.py test_calculator.py -v --cov
				'''
			    }
            }
	}
    }
