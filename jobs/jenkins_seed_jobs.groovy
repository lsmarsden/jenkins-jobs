job('jenkins_seed_jobs') {
    //Checkout the repo in Jenkins
    scm {
        git {
            remote {
                github('lsmarsden/jenkins-jobs')
            }
        }
    }
    steps {
        // process job DSL scripts
        dsl {
            // process DSL scripts from the job workspace
            external('jobs/*.groovy')

            removeAction('DELETE')
        }
    }
}
