# @capacitor-community/vosk

Offline speech recognition

## Install

```bash
npm install @capacitor-community/vosk
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
