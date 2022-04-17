pipelineJob('build_pipeline') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github('lsmarsden/jenkins-jobs')
                    }
                }
            }
            scriptPath('build_pipeline.Jenkinsfile')
        }
    }
}