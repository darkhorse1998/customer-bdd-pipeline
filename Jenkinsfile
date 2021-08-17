pipeline{

    agent any

    stages {

        stage('Build') { 
            steps {

                bat "mvn clean install"
            }
        }

        
         stage('Generate HTML report') {
            steps{
        			cucumber buildStatus: 'UNSTABLE',
                		reportTitle: 'My Cucumber Report',
                		fileIncludePattern: '**/*.json',
               			trendsLimit: 10,
                		classifications: [
                    		[
                        		'key': 'Browser',
                        		'value': 'Firefox'
                    		]
                		]
                  }
			}
           

        }

    }

