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
       stage('Code Coverage') {
	      steps
	           {  
		   sh '''
		      cd /home/ansadm
		      . calculator/bin/activate
		      cd /home/ansadm/workspace/pypipeline/
		      pytest calculator.py test_calculator.py -v --cov
		      '''
		}
            }
	stage('Unit Test') {
              steps
                {
                  sh '''
		        cd /home/ansadm
			. calculator/bin/activate
			cd /home/ansadm/workspace/pypipeline/
                        flake8 calculator.py test_calculator.py --statistics
		     '''
			 }
		    }
		  
	}
    }
