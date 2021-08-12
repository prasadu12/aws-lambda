pipeline {
    agent any
     
     triggers {
        pollSCM "* * * * *"
    }
    stages {
        stage('clone') {
            steps {
                //sh 'echo "Hello World"' 
                //sh 'git clone https://github.com/VnyKumar/demoapp.git' 
		//sh 'javac *java'
		//sh 'java  HelloWorld'
		 sh 'mvn -B -DskipTests clean package'
		 sh 'pwd'
		 //sh 'java -jar target/*jar '
                //git "https://github.com/VnyKumar/firstGit.git"
                
            }//steps
        }//stage
	    
	    stage('upload to s3'){
		    steps {
		    sh 'echo in s3 upload'
		    //sh 'aws s3 ls'
		    withAWS(credentials:'AWS-S3-Lambda') {
				sh "aws s3 ls s3://aws22bucket/ --recursive"
                                    
			    }
		    }
	    }
        
    }//stages
	
}//pipeline
