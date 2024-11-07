import Foundation

@objc public class Vosk: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
