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
		 sh 'cp target/*jar ../LambdaAPI.jar'
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
			    //sh "aws s3 cp build s3://tem-frontend-code/ --recursive"
			        sh 'aws lambda update-function-code  --function-name  demofunction3   --zip-file fileb://target/lambda-java-api-example-1.0-SNAPSHOT.jar'
                                    
			    }
		    }
	    }
        
    }//stages
	
}//pipeline
