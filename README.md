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
* [`requestMicrophonePermission()`](#requestmicrophonepermission)
* [`addListener('partialResult', ...)`](#addlistenerpartialresult-)
* [`addListener('onResult', ...)`](#addlisteneronresult-)
* [Interfaces](#interfaces)

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


### requestMicrophonePermission()

```typescript
requestMicrophonePermission() => Promise<void>
```

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
addListener(eventName: 'onResult', listener: (data: { final: string; }) => void) => Promise<PluginListenerHandle>
```

| Param           | Type                                               |
| --------------- | -------------------------------------------------- |
| **`eventName`** | <code>'onResult'</code>                            |
| **`listener`**  | <code>(data: { final: string; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>
