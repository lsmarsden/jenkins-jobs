job('jenkins_seed_jobs') {
    triggers {
        cron('H/15 * * * *')
    }
    //Checkout the repo in Jenkins
    scm {
        git {
            remote {
                github('lsmarsden/jenkins-jobs')
            }
            extensions {
                cleanBeforeCheckout()
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
