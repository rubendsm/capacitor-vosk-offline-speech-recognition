// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorCommunityVosk",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorCommunityVosk",
            targets: ["VoskPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "VoskPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/VoskPlugin"),
        .testTarget(
            name: "VoskPluginTests",
            dependencies: ["VoskPlugin"],
            path: "ios/Tests/VoskPluginTests")
    ]
)