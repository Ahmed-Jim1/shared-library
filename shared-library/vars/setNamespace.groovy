// vars/setNamespace.groovy

def call(String branchName) {
    def namespace = ""

    if (branchName.contains("dev")) {
        namespace = "dev"
    } else if (branchName.contains("test")) {
        namespace = "test"
    } else if (branchName == "main" || branchName.contains("prod")) {
        namespace = "prod"
    } else {
        error "Branch name '${branchName}' does not match any known namespace"
    }
    
    echo "Deploying to namespace: ${namespace}"
    return namespace
}
