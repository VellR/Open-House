package com.platform.open_house.main_runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.platform.open_house.runners.CreateItemRunner;
import com.platform.open_house.runners.RegisterUserRunner;
import com.platform.open_house.runners.SmokeTestRunner;

@RunWith(Suite.class)
@SuiteClasses({CreateItemRunner.class, RegisterUserRunner.class, SmokeTestRunner.class})
public class MainRunner {}
