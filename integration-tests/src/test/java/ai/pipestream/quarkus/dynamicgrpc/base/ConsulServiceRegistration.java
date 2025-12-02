package ai.pipestream.quarkus.dynamicgrpc.base;

import com.ecwid.consul.v1.ConsulClient;

/**
 * Helper class for registering gRPC services in Consul for testing.
 */
public class ConsulServiceRegistration {

    private final ConsulClient consulClient;

    public ConsulServiceRegistration(String consulHost, int consulPort) {
        this.consulClient = new ConsulClient(consulHost, consulPort);
    }

    /**
     * Register a gRPC service in Consul.
     */
    public void registerService(String serviceName, String serviceId, String host, int port) {
        com.ecwid.consul.v1.agent.model.NewService service = new com.ecwid.consul.v1.agent.model.NewService();
        service.setName(serviceName);
        service.setId(serviceId);
        service.setAddress(host);
        service.setPort(port);
        service.setTags(java.util.List.of("grpc"));

        consulClient.agentServiceRegister(service);
        System.out.println("Registered service: " + serviceName + " at " + host + ":" + port);
    }

    /**
     * Deregister a service from Consul.
     */
    public void deregisterService(String serviceId) {
        consulClient.agentServiceDeregister(serviceId);
        System.out.println("Deregistered service: " + serviceId);
    }

    /**
     * Get the Consul client for advanced operations.
     */
    public ConsulClient getConsulClient() {
        return consulClient;
    }
}
