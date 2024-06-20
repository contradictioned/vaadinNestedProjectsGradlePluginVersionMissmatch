import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

buildscript {
    repositories {
    	mavenCentral()
	    maven { setUrl("https://maven.vaadin.com/vaadin-prereleases") }
			maven { setUrl("https://repo.spring.io/milestone") }
		}
}

plugins {
	id("org.springframework.boot") version "3.1.5" apply false
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("java")
	id("com.vaadin") version "24.3.12" apply false
}

allprojects {
	repositories {
		mavenCentral()
		maven { setUrl("https://maven.vaadin.com/vaadin-prereleases") }
		maven { setUrl("https://repo.spring.io/milestone") }
		maven { setUrl("https://maven.vaadin.com/vaadin-addons") }
	}

	apply(plugin = "io.spring.dependency-management")
	configure<DependencyManagementExtension> {
		imports {
			mavenBom("com.vaadin:vaadin-bom:24.4.3")
		}
	}
}