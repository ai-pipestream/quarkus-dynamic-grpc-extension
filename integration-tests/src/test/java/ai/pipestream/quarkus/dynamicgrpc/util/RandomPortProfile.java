package ai.pipestream.quarkus.dynamicgrpc.util;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Map;

/**
 * Test profile that configures Quarkus gRPC server to use a random available port.
 * Useful for parallel test execution to avoid port conflicts.
 * <p>
 * Migrated from platform-libraries/libraries/dynamic-grpc test suite.
 * </p>
 */
public class RandomPortProfile implements QuarkusTestProfile {
    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of("quarkus.grpc.server.port", "0");
    }
}
