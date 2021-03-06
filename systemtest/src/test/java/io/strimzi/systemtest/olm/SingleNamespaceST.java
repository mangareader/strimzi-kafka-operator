/*
 * Copyright Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.systemtest.olm;

import io.strimzi.systemtest.resources.OlmResource;
import io.strimzi.systemtest.resources.ResourceManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SingleNamespaceST extends OlmBaseST {

    public static final String NAMESPACE = "olm-namespace";

    private static final Logger LOGGER = LogManager.getLogger(SingleNamespaceST.class);

    @Test
    @Order(1)
    void testDeployExampleKafka() {
        doTestDeployExampleKafka();
    }

    @Test
    @Order(2)
    void testDeployExampleKafkaUser() {
        doTestDeployExampleKafkaUser();
    }

    @Test
    @Order(3)
    void testDeployExampleKafkaTopic() {
        doTestDeployExampleKafkaTopic();
    }

    @Test
    @Order(4)
    void testDeployExampleKafkaConnect() {
        doTestDeployExampleKafkaConnect();
    }

    @Test
    @Order(5)
    void testDeployExampleKafkaConnectS2I() {
        doTestDeployExampleKafkaConnectS2I();
    }

    @Test
    @Order(6)
    void testDeployExampleKafkaBridge() {
        doTestDeployExampleKafkaBridge();
    }

    @Test
    @Order(7)
    void testDeployExampleKafkaMirrorMaker() {
        doTestDeployExampleKafkaMirrorMaker();
    }

    @Test
    @Order(8)
    void testDeployExampleKafkaMirrorMaker2() {
        doTestDeployExampleKafkaMirrorMaker2();
    }

    @BeforeAll
    void setup() throws Exception {
        ResourceManager.setClassResources();
        cluster.setNamespace(NAMESPACE);
        cluster.createNamespace(NAMESPACE);
        OlmResource.clusterOperator(NAMESPACE);
    }
}
