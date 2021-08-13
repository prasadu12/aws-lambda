pipeline {
    agent any
     
     triggers {
        pollSCM "* * * * *"
    }
    stages {
        stage('clone') {
            steps {
               sh 'echo "Hello World"' 
       sh 'mvn -B -DskipTests clean package'
     sh 'cp target/*jar ../${BUILD_NUMBER}_LambdaAPI.jar'
     
         
            }//steps
        }//stage
     
     stage('deploy to lambda'){
      steps {
       
    //sh 'Uploading to S3....'
         withAWS(credentials:'AWS-S3-Lambda') {
      
                sh 'aws lambda update-function-code  --function-name  demofunction3   --zip-file fileb://target/lambda-java-api-example-1.0-SNAPSHOT.jar'

             }
          
                                    
       }
      }
     
        
    }//stages
 

     
 
}//pipeline


