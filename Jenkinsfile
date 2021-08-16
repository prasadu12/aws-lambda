pipeline {
    agent {
        label '!windows'
    }

    environment {
        FUNC_NAME   = 'demo-function'
	TEST_FUNC   =  'temp'
	 HANDLER = 'com.techprimers.aws.LambdaJavaAPI'
	 ARN  = 'arn:aws:iam::125855726099:role/lambda-example'
	  
    }
	parameters {
    choice(
      name: 'Env',
      choices: ['BRANCH', 'RELEASE'],
      description: 'Passing the Environment'
    )
   
  }
     triggers {
        pollSCM "* * * * *"
    }
	
	
    stages {
        stage('build zip-file') {
            steps {
					sh 'mvn -B -DskipTests clean package'
		                 
				  }//steps
				}//stage
	    
	    stage('Create Function'){
						when { expression { params.Env == "BRANCH" } }
					steps {
							echo " The environment is ${params.Env}"
							withAWS(region:'us-west-2',credentials:'AWSLoginCred'){
							// sh "aws lambda create-function --function-name "demo-function" --zip-file fileb://target/lambda-java-api-example-1.0-SNAPSHOT.jar --handler "com.techprimers.aws.LambdaJavaAPI" --runtime java8 --role arn:aws:iam::125855726099:role/lambda-example"
							sh "aws lambda create-function --function-name $env.FUNC_NAME --runtime java8  --zip-file fileb://target/lambda-java-api-example-1.0-SNAPSHOT.jar --handler $env.HANDLER  --role $env.ARN"
							//API Gateway has to create Manually- As cli Integration not working
							//sh "aws lambda create-function --function-name demofunction2  --runtime java8  --zip-file fileb://target/lambda-java-api-example-1.0-SNAPSHOT.jar --role arn:aws:iam::125855726099:role/lambda-example --handler com.techprimers.aws.LambdaJavaAPI"
							}
						}  					    
		    }
		stage('Upload Function'){
						when { expression { params.Env == "RELEASE" } }
					steps {
							echo " The environment is ${params.Env}"
							withAWS(region:'us-west-2',credentials:'AWSLoginCred'){
							 sh "aws lambda update-function-code  --function-name $env.FUNC_NAME   --zip-file fileb://target/lambda-java-api-example-1.0-SNAPSHOT.jar "
							 }
						}  					    
		    }	
	    
        }//stages
}//pipeline

