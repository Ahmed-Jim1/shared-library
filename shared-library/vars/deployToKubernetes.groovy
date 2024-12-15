// vars/deployToKubernetes.groovy

def call(String namespace) {
    // Use credentials to fetch the Kubernetes kubeconfig
    withCredentials([file(credentialsId: 'aks', variable: 'KUBECONFIG')]) {
        // Deploy to Kubernetes using the provided namespace
        sh """
            export KUBECONFIG=${KUBECONFIG}
            kubectl apply -f deployment.yaml --namespace=${namespace}
            kubectl rollout status deployment/your-app --namespace=${namespace}
        """
    }
}

