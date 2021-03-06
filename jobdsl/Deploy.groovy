def allowedEnvironments = [
	"dev",
	"qa",
	"e2e",
	"test",
	"perf",
	"stage",
	"prod"
]


for ( curEnv in allowedEnvironments ) {

	job ( "${YOUR_USER_NAME}Deploy${curEnv}" ) {

		description ( 'generated by Job DSL on ' + new Date ( ) )
		logRotator  ( -1, 50, -1, 50 )

		parameters {
			stringParam ( "ARTIFACT_S3_URL", "", "url for the app to be deployed" )
		}

		scm {
			git {
				branch ( 'origin/master' )
				remote {
					url         ( "${GIT_REPO_SSH_URL}"  )
					credentials ( "${GIT_CREDENTIAL_ID}" )
				}
			}
		}

		steps {
			shell (
	"""#!/bin/bash
	
echo
echo insert code here to pull your war file from your s3 bucket
echo insert code here to run your cloudformation script to deploy to your ${curEnv} environment
echo
	""")
		}
	}

}