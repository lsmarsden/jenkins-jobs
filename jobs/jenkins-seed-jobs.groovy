job('jenkins-seed-jobs') {
    //Checkout the repo in Jenkins
    scm {
        git('https://github.com/lsmarsden/jenkins-jobs.git')
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
