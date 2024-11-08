# vosk-offline-speech-recognition

Capacitor Plugin for Ionic - Offline Speech Recognition with Vosk Android

This project uses the Vosk Android library, which is licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

## Requirements

You will need to download the Vosk models from the following link:

[Vosk Models](https://alphacephei.com/vosk/models)

1. Download the smallest Portuguese model: `vosk-model-small-pt-0.3`
2. Rename the model to `vosk-model-small-pt`.
3. Place the model in the following directory: `yourIonicApp\android\app\src\main\assets`


## Install

```bash
npm i vosk-offline-speech-recognition
npx cap sync
```

## API

<docgen-index>

* [`startListening()`](#startlistening)
* [`stopListening()`](#stoplistening)
* [`pauseListening()`](#pauselistening)
* [`resumeListening()`](#resumelistening)
* [`isListening()`](#islistening)
* [`available()`](#available)
* [`requestPermissions()`](#requestpermissions)
* [`addListener('partialResult', ...)`](#addlistenerpartialresult-)
* [`addListener('onResult', ...)`](#addlisteneronresult-)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### startListening()

```typescript
startListening() => Promise<void>
```

--------------------


### stopListening()

```typescript
stopListening() => Promise<void>
```

--------------------


### pauseListening()

```typescript
pauseListening() => Promise<void>
```

--------------------


### resumeListening()

```typescript
resumeListening() => Promise<void>
```

--------------------


### isListening()

```typescript
isListening() => Promise<{ isListening: boolean; }>
```

**Returns:** <code>Promise&lt;{ isListening: boolean; }&gt;</code>

--------------------


### available()

```typescript
available() => Promise<{ available: boolean; }>
```

**Returns:** <code>Promise&lt;{ available: boolean; }&gt;</code>

--------------------


### requestPermissions()

```typescript
requestPermissions() => Promise<PermissionStatus>
```

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

--------------------


### addListener('partialResult', ...)

```typescript
addListener(eventName: 'partialResult', listener: (data: { matches: string; }) => void) => Promise<PluginListenerHandle>
```

| Param           | Type                                                 |
| --------------- | ---------------------------------------------------- |
| **`eventName`** | <code>'partialResult'</code>                         |
| **`listener`**  | <code>(data: { matches: string; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### addListener('onResult', ...)

```typescript
addListener(eventName: 'onResult', listener: (data: { result: string; }) => void) => Promise<PluginListenerHandle>
```

| Param           | Type                                                |
| --------------- | --------------------------------------------------- |
| **`eventName`** | <code>'onResult'</code>                             |
| **`listener`**  | <code>(data: { result: string; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### Interfaces


#### PermissionStatus

| Prop                    | Type                                                        | Description                                                                                                                                                                      |
| ----------------------- | ----------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`speechRecognition`** | <code><a href="#permissionstate">PermissionState</a></code> | Permission state for speechRecognition alias. On Android it requests/checks RECORD_AUDIO permission On iOS it requests/checks the speech recognition and microphone permissions. |


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


### Type Aliases


#### PermissionState

<code>'prompt' | 'prompt-with-rationale' | 'granted' | 'denied'</code>

</docgen-api>
