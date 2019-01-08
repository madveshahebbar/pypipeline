pipeline
{
    parameters
    {
	  string(name: 'REPOSITORY_URL', defaultValue: '', description: '<BR><font color=RED>*</font> URL to GIT repository')
	  string(name: 'GIT_REPO_CRED', defaultValue: '', description: '<BR><font color=RED>*</font> Credential name of GIT user')
	  string(name: 'BRANCH', defaultValue: 'master', description: '<BR>Name of branch (default: master)')
	}
	 
	agent any
	{
	   stages
	    {
	      stage('CheckOut')
	        {    
	          steps
		        { 
		         checkout([  $class: 'GitSCM', branches: [[name: BRANCH]],userRemoteConfigs: [[url: "${REPOSITORY_URL}", credentialsId: "${GIT_REPO_CRED}"]]
				}
			}
		}
	}
}
