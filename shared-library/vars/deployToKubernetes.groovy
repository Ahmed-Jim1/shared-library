// vars/deployToKubernetes.groovy

def call(String namespace) {
    // Deploy to Kubernetes using the provided namespace
    sh """
        kubectl apply -f k8s-deployment.yaml --namespace=${namespace}
        kubectl rollout status deployment/your-app --namespace=${namespace}
    """
}
