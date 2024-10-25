package com.swaggerautoconfbean.test.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.activation.DataSource;

import org.junit.jupiter.api.Test;

import com.stackroute.swaggerautoconfbean.config.CustomDataSource;

public class CustomDataSourceTest {
    @Test
    public void customDataSourceShouldNotBeNull() {
        // Arrange
       DataSource dataSource = new CustomDataSource();

        // Act and Assert
        assertNotNull(dataSource, "Custom DataSource should not be null");
    }
}
