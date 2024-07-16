package com.musinsa.codi.core.tdd;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.EnabledIf;

@EnabledIf(expression = "#{environment.acceptsProfiles('local')}", loadContext = true)
@ExtendWith(MockitoExtension.class)
public class BaseUnitTest {
}
