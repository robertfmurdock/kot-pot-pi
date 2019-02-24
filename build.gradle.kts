import com.zegreatrob.kotpotpi.build.BuildConstants

plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.3.21"
    id("com.github.ben-manes.versions") version "0.20.0"
}

repositories {
    mavenCentral()
}

kotlin {
    targets {
        macosX64 {
            binaries {
                executable {
                    // Binary configuration.
                }
            }
        }
        linuxX64 {
            binaries {
                executable {
                    // Binary configuration.
                }
            }
        }
        linuxArm32Hfp {
            binaries {
                executable {
                    // Binary configuration.
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:${BuildConstants.kotlinVersion}")
                implementation("org.jetbrains.kotlin:kotlin-test-common:${BuildConstants.kotlinVersion}")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common:${BuildConstants.kotlinVersion}")
            }
        }

        val nativeCommonMain by creating {
            dependsOn(commonMain)
        }

        val macosX64Main by getting {
            dependsOn(nativeCommonMain)
        }

        val linuxX64Main by getting {
            dependsOn(nativeCommonMain)
        }

        val linuxArm32HfpMain by getting {
            dependsOn(nativeCommonMain)
        }

    }
}

tasks {

    val runExeLinux by creating(Exec::class) {
        dependsOn("linuxX64MainBinaries")
        executable = "build/bin/linuxX64/releaseExecutable/app.kexe"
    }

    val runExeLinuxArm32 by creating(Exec::class) {
        dependsOn("linuxArm32HfpMainBinaries")
        executable = "build/bin/linuxArm32Hfp/releaseExecutable/app.kexe"
    }

}